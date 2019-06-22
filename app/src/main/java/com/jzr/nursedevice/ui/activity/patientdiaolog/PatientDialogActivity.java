package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.ui.activity.VoipActivity;
import com.jzr.nursedevice.utils.CommonUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class PatientDialogActivity extends BaseActivity {

    private PatientInfoBean.DataBean item;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_bed_no)
    TextView tvBedNo;
    @BindView(R.id.tv_cure_no)
    TextView tvCureNo;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_nurse_level)
    TextView tvNurseLevel;

    @BindView(R.id.ll_patient_info)
    LinearLayout llPatientInfo;
    @BindView(R.id.ll_nurselevel_bg)
    LinearLayout llNurseLevelBg;
    @BindView(R.id.rl_orders)
    RelativeLayout rlOrders;
    @BindView(R.id.rl_symptom)
    RelativeLayout rlSymptom;
    @BindView(R.id.rl_publicity)
    RelativeLayout rlPublicity;
    @BindView(R.id.rl_inspect)
    RelativeLayout rlInspect;
    @BindView(R.id.rl_tem)
    RelativeLayout rlTem;
    @BindView(R.id.rl_nursing)
    RelativeLayout rlNursing;
    @BindView(R.id.rl_evaluation)
    RelativeLayout rlEvaluation;
    @BindView(R.id.rl_control)
    RelativeLayout rlControl;
    @BindView(R.id.rl_dialyse)
    RelativeLayout rlDialyse;
    @BindView(R.id.rl_picture)
    RelativeLayout rlPicture;
    @BindView(R.id.rl_inquiry)
    RelativeLayout rlInquiry;
    @BindView(R.id.rl_out)
    RelativeLayout rlOut;
    @BindView(R.id.bt_dismiss)
    Button btDismiss;
    @BindView(R.id.rl_infusion)
    RelativeLayout rlInfusion;
    @BindView(R.id.rl_videocall)
    RelativeLayout rlVideoCall;
    private Intent pIntent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_patient_dialog;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        String pData = getIntent().getStringExtra("data");
        item = new Gson().fromJson(pData, PatientInfoBean.DataBean.class);
        tvName.setText(CommonUtil.replaceString2Star(item.getName(),1,1));
        tvAge.setText(item.getAge());
        tvCureNo.setText(item.getCureNo());
        tvSex.setText(item.getSexText());
        tvBedNo.setText(item.getBedName());
        llNurseLevelBg.setBackgroundColor(Color.parseColor(item.getNurseLevelBgColor()));
        tvNurseLevel.setText(item.getNurseLevelName());
        tvNurseLevel.setTextColor(Color.parseColor(item.getNurseLevelFontColor()));

    }

    @OnClick({R.id.ll_patient_info, R.id.rl_orders, R.id.rl_symptom, R.id.rl_publicity, R.id.rl_inspect, R.id.rl_tem,
            R.id.rl_nursing, R.id.rl_evaluation, R.id.rl_control, R.id.rl_dialyse, R.id.rl_picture, R.id.rl_inquiry, R.id.rl_out,
            R.id.bt_dismiss,R.id.rl_infusion,R.id.rl_videocall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_patient_info:// 跳轉到病人詳情頁面
                pIntent = new Intent(this, PatientDetailsActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_orders: //  跳轉到医嘱執行頁面
                pIntent = new Intent(this, DoctorActionActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_symptom: //  跳轉到生命體徵頁面
                pIntent = new Intent(this, VitalSignsActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_infusion: //  跳轉到绑定输液仪
                pIntent = new Intent(this, InfusionActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_publicity:
                // 跳转到宣教页面
                pIntent = new Intent(this, PublicityActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_inspect:
                //  跳轉到巡視頁面
                pIntent = new Intent(this, PatrolActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_tem:
                //  跳轉到体温单頁面
                pIntent = new Intent(this, TemperatureActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_nursing:
                //  跳轉到护理文书頁面
                pIntent = new Intent(this, NursingActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case R.id.rl_evaluation:
                //  跳轉到评估頁面
                pIntent = new Intent(this, EvaluationActivity.class);
                pIntent.putExtra("data", new Gson().toJson(item));
                startActivityIn(pIntent, this);
                break;
            case  R.id.rl_videocall:
                //  视频通话

                Intent intent = new Intent(this, VoipActivity.class);
                intent.putExtra("targetId", item.getDeviceIp());
                intent.putExtra(VoipActivity.ACTION, VoipActivity.CALLING);
                startActivityIn(intent, this);

                break;
            case R.id.rl_control:
                break;
            case R.id.rl_dialyse:
                break;
            case R.id.rl_picture:
                break;
            case R.id.rl_inquiry:
                break;
            case R.id.rl_out:
                break;
            case R.id.bt_dismiss:
                finish();
                break;
        }
    }
}
