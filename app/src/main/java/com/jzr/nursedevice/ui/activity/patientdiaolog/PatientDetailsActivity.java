package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.ChargeInfoBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.presenter.contract.activity.PatientDetailsContract;
import com.jzr.nursedevice.presenter.impl.activity.PatientDetailsActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class PatientDetailsActivity extends BaseActivity implements PatientDetailsContract.View {


    private PatientDetailsActivityPresenter presenter = new PatientDetailsActivityPresenter();

    private PatientInfoBean.DataBean item;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_cure_no)
    TextView tvCureNo;
    @BindView(R.id.tv_admission_time)
    TextView tvAdmissionTime;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_bed_no)
    TextView tvBedNo;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_duties)
    TextView tvDuties;
    @BindView(R.id.tv_nation)
    TextView tvNation;
    @BindView(R.id.tv_id_number)
    TextView tvIdNumber;
    @BindView(R.id.tv_diagnose)
    TextView tvDiagnose;
    @BindView(R.id.tv_doctor)
    TextView tvDoctor;
    @BindView(R.id.tv_all_charge)
    TextView tvAllCharge;
    @BindView(R.id.tv_balence)
    TextView tvBalence;
    @BindView(R.id.tv_charge_days)
    TextView tvChargeDays;
    @BindView(R.id.tv_fee_type)
    TextView tvFeeType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_deatils;
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

        actionbarTitle.setText(item.getName() + "  " + item.getBedName() + "  " + item.getCureNo());
        leftTitle.setText("患者详情");

        tvName.setText(item.getName());
        tvCureNo.setText(item.getCureNo());
        tvAdmissionTime.setText(item.getInTime());
        tvAge.setText(item.getAge());

        tvBedNo.setText(item.getBedName());
        tvPhone.setText(item.getMobile());
        tvDuties.setText(item.getDuties());
        tvDiagnose.setText(item.getDiagnose());
        tvDoctor.setText(item.getDoctorName());
//        tvNation.setText(item.getNa);
        presenter.FetchPatientChargeInfo("patientCode", item.getCode(), "patientCureNo", item.getCureNo());
        showWaitingDialog(getString(R.string.loading));
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
    public void FetchPatientChargeInfoSuccess(ChargeInfoBean data) {
        hideWaitingDialog();
        tvAllCharge.setText(String.valueOf(data.getData().getAllCharge()));
        tvBalence.setText(String.valueOf(data.getData().getBalence()));
        tvChargeDays.setText(String.valueOf(data.getData().getChargeDays()));
        tvFeeType.setText(String.valueOf(data.getData().getFeeType()));
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }
}
