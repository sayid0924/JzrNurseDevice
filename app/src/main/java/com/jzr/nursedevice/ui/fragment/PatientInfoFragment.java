package com.jzr.nursedevice.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.KeyboardUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.db.database.PatientBeanDbDao;
import com.jzr.nursedevice.db.entity.PatientBeanDb;
import com.jzr.nursedevice.presenter.contract.fragment.PatientInfoContract;
import com.jzr.nursedevice.presenter.impl.fragment.PatientInfoFragmentPresenter;
import com.jzr.nursedevice.ui.activity.HomeActivity;
import com.jzr.nursedevice.ui.activity.LoginActivity;
import com.jzr.nursedevice.ui.activity.patientdiaolog.PatientDialogActivity;
import com.jzr.nursedevice.ui.apadter.PatientApadter;
import com.jzr.nursedevice.utils.GreenDaoUtil;
import com.jzr.nursedevice.utils.PreferUtil;
import com.jzr.nursedevice.view.dialog.CustomDialog;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PatientInfoFragment extends BaseFragment implements PatientInfoContract.View, SwipeRefreshLayout.OnRefreshListener {


    private PatientInfoFragmentPresenter presenter = new PatientInfoFragmentPresenter();

    private PatientApadter apadter;
    private List<PatientInfoBean.DataBean> data= new ArrayList<>();
    private List<PatientInfoBean.DataBean> searchData = new ArrayList<>();


    private static PatientInfoFragment patientInfoFragment;

    @BindView(R.id.rv_patient)
    RecyclerView rvPatient;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;

    @BindView(R.id.ed_search)
    EditText edSearch;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    private PatientBeanDbDao collectionInfoDao;
    private CustomDialog mDialog;


    public static PatientInfoFragment newInstance() {
        patientInfoFragment = new PatientInfoFragment();
        return patientInfoFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_patientinfo;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void initView(Bundle bundle) {
        presenter.FetchPatientList("deptCode", PreferUtil.getInstance().getDeptCode());
        showWaitingDialog(getString(R.string.loading));
        tvUsername.setText(PreferUtil.getInstance().getUserName());

        apadter = new PatientApadter(data, getSupportActivity());
        rvPatient.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvPatient.setAdapter(apadter);

        apadter.onItemClick(new PatientApadter.onItemClick() {
            @Override
            public void onItemClick(PatientInfoBean.DataBean item) {
                Intent pIntent = new Intent(getSupportActivity(), PatientDialogActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                HomeActivity.homeActivity.startActivityIn(pIntent, getSupportActivity());
            }
        });
        srl.setOnRefreshListener(this);

        edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                KeyboardUtils.hideSoftInput(getSupportActivity());
                searchData.clear();
                for(int n =0; n<data.size();n++){
                    if(data.get(n).getName().contains(edSearch.getText().toString())||data.get(n).getCureNo().contains(edSearch.getText().toString())){
                        searchData.add(data.get(n));
                    }
                }
                apadter.setNewData(searchData);
                apadter.notifyDataSetChanged();
                return false;
            }
        });

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchData.clear();
                for(int i =0; i<data.size();i++){
                    if(data.get(i).getName().contains(edSearch.getText().toString())||data.get(i).getCureNo().contains(edSearch.getText().toString())){
                        searchData.add(data.get(i));
                    }
                }
                apadter.setNewData(searchData);
                apadter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.rl_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_name:
                showDialog();
                break;
        }
    }

    /**
     * 显示等待提示框
     */
    public Dialog showDialog() {
        hideActionDialog();
        View view = View.inflate(getSupportActivity(), R.layout.dialog_outloging, null);

        view.findViewById(R.id.bt_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActivity().finish();
                PreferUtil.getInstance().setAutomaticLogin(false);
                startActivity(new Intent(getSupportActivity(), LoginActivity.class));
            }
        });
        view.findViewById(R.id.bt_clecn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });

        mDialog = new CustomDialog(getSupportActivity(), view, R.style.MyDialog);
        mDialog.show();
        mDialog.setCancelable(false);
        return mDialog;
    }

    @Override
    public void onDestroy() {
        hideActionDialog();
        super.onDestroy();
    }

    /**
     * 隐藏等待提示框
     */
    public void hideActionDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    public void FetchPatientListSuccess(PatientInfoBean patientInfoBean) {
        hideWaitingDialog();
        if(srl.isRefreshing())srl.setRefreshing(false);
        data.clear();
        edSearch.setText("");
        data = patientInfoBean.getData();
        apadter.setNewData(data);
        apadter.notifyDataSetChanged();

        collectionInfoDao = GreenDaoUtil.getDaoSession().getPatientBeanDbDao();
        PatientBeanDb patientBeanDb = collectionInfoDao.queryBuilder().where(PatientBeanDbDao.Properties.Id.eq(0)).unique();
        PatientBeanDb patiemtDb = new PatientBeanDb();
        if (patientBeanDb != null) {
            patiemtDb.setId(patientBeanDb.getId());
            patiemtDb.setBedInfoBean(patientInfoBean);
            collectionInfoDao.update(patiemtDb);
        } else {
            patiemtDb.setId(Long.valueOf(0));
            patiemtDb.setBedInfoBean(patientInfoBean);
            collectionInfoDao.insert(patiemtDb);
        }
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

    @Override
    public void onRefresh() {
        presenter.FetchPatientList("deptCode", PreferUtil.getInstance().getDeptCode());
    }
}
