package com.jzr.nursedevice.ui.fragment.doctoraction;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.presenter.contract.fragment.NoActionContract;
import com.jzr.nursedevice.presenter.impl.fragment.NoActionFragmentPresenter;
import com.jzr.nursedevice.ui.activity.patientdiaolog.DoctorActionActivity;
import com.jzr.nursedevice.ui.apadter.DoctorActionApadter;
import com.jzr.nursedevice.utils.JsonUtils;
import com.jzr.nursedevice.view.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class NoActionFragment extends BaseFragment implements NoActionContract.View, SwipeRefreshLayout.OnRefreshListener {

    private NoActionFragmentPresenter presenter = new NoActionFragmentPresenter();
    public static NoActionFragment noActionFragment;
    private DoctorActionApadter apadter;
    private PatientInfoBean.DataBean dataBean;
    private List<DoctorActionBean.DataBean> data = new ArrayList<>();
    private List<DoctorActionBean.DataBean> longData = new ArrayList<>();
    private List<DoctorActionBean.DataBean> shortData = new ArrayList<>();
    private int type;
    @BindView(R.id.rv_action)
    RecyclerView rvAction;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    private Dialog mDialogAction;

    public static NoActionFragment newInstance(PatientInfoBean.DataBean data, int type) {
        noActionFragment = new NoActionFragment();
        noActionFragment.dataBean = data;
        // 0 长期 1 所有  2  临时
        noActionFragment.type = type;
        return noActionFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_no_action;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void initView(Bundle bundle) {

        presenter.FetchDoctorOrderList("patientCode", dataBean.getCode(), "patientCureNo", dataBean.getCureNo());
        showWaitingDialog(getString(R.string.loading));
        apadter = new DoctorActionApadter(data, getSupportActivity());
        rvAction.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvAction.setAdapter(apadter);
        srl.setOnRefreshListener(this);

        apadter.onItemClick(new DoctorActionApadter.onItemClick() {
            @Override
            public void onItemClick(DoctorActionBean.DataBean item) {
                showActionDialog(item);
            }
        });

    }

    public void RefreshData() {
        presenter.FetchDoctorOrderList("patientCode", dataBean.getCode(), "patientCureNo", dataBean.getCureNo());
    }

    @Override
    public void FetchDoctorOrderListSuccess(DoctorActionBean doctorActionBean) {

        if (srl.isRefreshing()) srl.setRefreshing(false);
        data.clear();
        longData.clear();
        hideWaitingDialog();
        data = doctorActionBean.getData();
        switch (type) {
            case 0:
                for (int i = 0; i < data.size(); i++) {
                    //   医嘱类型: 0=临嘱, 1=长嘱
                    if (data.get(i).getOrderType()==1 && data.get(i).getIsExec() == 0) {
                        longData.add(data.get(i));
                    }
                }
                apadter.setNewData(longData);

                break;
            case 1:
                apadter.setNewData(data);
                break;
            case 2:
                for (int i = 0; i < data.size(); i++) {
                 //   医嘱类型: 0=临嘱, 1=长嘱
                    if (data.get(i).getOrderType() ==0 && data.get(i).getIsExec() == 0) {

                        shortData.add(data.get(i));
                    }
                }
                apadter.setNewData(shortData);
                break;
        }
    }

    @Override
    public void FetchDoctorOrderExecSuccess(ExecActionBean execActionBean) {
        if(DoctorActionActivity.doctorActionActivity!=null){
            DoctorActionActivity.doctorActionActivity.RefreshData();
        }
        hideWaitingDialog();
        ToastUtils.showLongToast("执行成功");
        presenter.FetchDoctorOrderList("patientCode", dataBean.getCode(), "patientCureNo", dataBean.getCureNo());
        showWaitingDialog("加载中... ");
    }

    /**
     * 显示执行医嘱提示框
     */
    public void showActionDialog(final DoctorActionBean.DataBean item) {
        hideActionDialog();

        View view = View.inflate(getSupportActivity(), R.layout.dialog_action, null);

        ((TextView) view.findViewById(R.id.tv_name)).setText(dataBean.getName());
        ((TextView) view.findViewById(R.id.tv_cure_no)).setText(item.getPatientCureNo());

        ((TextView) view.findViewById(R.id.tv_order_name)).setText(item.getOrderName());
        ((TextView) view.findViewById(R.id.tv_usedate)).setText(item.getUseDate());
        Button btPost = view.findViewById(R.id.bt_post);
        btPost.setText("确认执行医嘱");
        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取消执行医嘱
                presenter.FetchDoctorOrderExec("orderNo", item.getOrderNo());
                mDialogAction.dismiss();
                showWaitingDialog("正在执行医嘱....");
            }
        });

        view.findViewById(R.id.bt_clecn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialogAction.dismiss();
            }
        });

        mDialogAction = new CustomDialog(getSupportActivity(), view, R.style.MyDialog);
        mDialogAction.show();
        mDialogAction.setCancelable(false);
    }

    /**
     * 隐藏取消执行医嘱提示框
     */
    public void hideActionDialog() {
        if (mDialogAction != null && mDialogAction.isShowing()) {
            mDialogAction.dismiss();
            mDialogAction = null;
        }
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

    @Override
    public void onRefresh() {
        RefreshData();
    }

}
