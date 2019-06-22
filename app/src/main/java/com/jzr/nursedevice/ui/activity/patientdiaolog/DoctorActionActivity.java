package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.BaseFragmentPageAdapter;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.CodeDataOfDoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.bean.TabEntity;
import com.jzr.nursedevice.presenter.contract.activity.DoctorActionContract;
import com.jzr.nursedevice.presenter.impl.activity.DoctorActionActivityPresenter;
import com.jzr.nursedevice.ui.fragment.patient.AllActionFragment;
import com.jzr.nursedevice.ui.fragment.patient.LongActionFragment;
import com.jzr.nursedevice.ui.fragment.patient.ShortActionFragment;
import com.jzr.nursedevice.view.dialog.CustomDialog;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class DoctorActionActivity extends BaseActivity implements DoctorActionContract.View {

    private DoctorActionActivityPresenter presenter = new DoctorActionActivityPresenter();

    private PatientInfoBean.DataBean item;

    private String[] mTitles = {"长期医嘱", "所有医嘱", "临时医嘱"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTitleList = new ArrayList<>();
    private DoctorActionBean data;
    public static DoctorActionActivity doctorActionActivity;

    private int[] mIconUnselectIds = {
            R.drawable.icon_nurse, R.drawable.icon_patient,
            R.drawable.icon_message, R.drawable.icon_move};

    private int[] mIconSelectIds = {
            R.drawable.icon_nurse_n, R.drawable.icon_patient_n,
            R.drawable.icon_message_n_, R.drawable.icon_move_n};

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    private CustomDialog mDialogAction;


    @Override
    public int getLayoutId() {
        return R.layout.activity_doctor_action;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    public void detachView() {
        presenter.detachView();
    }

    @Override
    public void initView() {
        setSwipeBackEnable(true);
        String pData = getIntent().getStringExtra("data");
        item = new Gson().fromJson(pData, PatientInfoBean.DataBean.class);
        actionbarTitle.setText(item.getName() + "  " + item.getBedName() + "床  " + item.getCureNo());
        leftTitle.setText("医嘱执行");
        presenter.FetchDoctorOrderList("patientCode", item.getCode(), "patientCureNo", item.getCureNo());
        showWaitingDialog(getString(R.string.loading));
        doctorActionActivity = this;
        mFragments.add(LongActionFragment.newInstance(item));
        mFragments.add(AllActionFragment.newInstance(item));
        mFragments.add(ShortActionFragment.newInstance(item));

        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        tabLayout.setTabData(mTabEntities);

        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Subscribe
    public void getEventBus(CodeDataOfDoctorActionBean codeDataOfDoctorActionBean) {
        String codeData = codeDataOfDoctorActionBean.getCodeData();
        String[] patientData = codeData.split(":");
        String patientNo = patientData[3].trim();

        for (int i = 0; i < data.getData().size(); i++) {
            if (patientNo.equals(data.getData().get(i).getOrderNo())) {
                showActionDialog(data.getData().get(i));
            }
        }

    }

    /**
     * 显示执行医嘱提示框
     */
    public Dialog showActionDialog(final DoctorActionBean.DataBean item) {
        hideActionDialog();

        View view = View.inflate(this, R.layout.dialog_action, null);

        ((TextView) view.findViewById(R.id.tv_name)).setText(item.getOrderName() + " " + item.getStandards());
        ((TextView) view.findViewById(R.id.tv_cure_no)).setText(item.getPatientCureNo());

        ((TextView) view.findViewById(R.id.tv_order_name)).setText(item.getOrderName());
        ((TextView) view.findViewById(R.id.tv_usedate)).setText(item.getUseDate());

        view.findViewById(R.id.bt_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 执行医嘱
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

        mDialogAction = new CustomDialog(this, view, R.style.MyDialog);
        mDialogAction.show();
        mDialogAction.setCancelable(false);
        return mDialogAction;

    }

    /**
     * 隐藏等待提示框
     */
    public void hideActionDialog() {
        if (mDialogAction != null && mDialogAction.isShowing()) {
            mDialogAction.dismiss();
            mDialogAction = null;
        }
    }

    @OnClick({R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }


    @Override
    public void FetchDoctorOrderListSuccess(DoctorActionBean doctorActionBean) {
       hideWaitingDialog();
        data = null;
        data = doctorActionBean;

    }

    @Override
    public void FetchDoctorOrderExecSuccess(ExecActionBean doctorActionBean) {
        hideWaitingDialog();
        RefreshData();
        ToastUtils.showLongToast(doctorActionBean.getMessage());
    }

    public void RefreshData() {
        LongActionFragment.longActionFragment.RefreshData();
        AllActionFragment.allActionFragment.RefreshData();
        ShortActionFragment.shortActionFragment.RefreshData();
    }


    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }
}
