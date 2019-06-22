package com.jzr.nursedevice.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jzr.nursedevice.base.BaseApplication;
import com.jzr.nursedevice.bean.CodeDataOfDoctorActionBean;
import com.jzr.nursedevice.bean.CodeDataOfHomeBean;
import com.jzr.nursedevice.bean.CodeDataOfInfusionBean;
import com.jzr.nursedevice.ui.activity.HomeActivity;
import com.jzr.nursedevice.ui.activity.patientdiaolog.DoctorActionActivity;
import com.jzr.nursedevice.ui.activity.patientdiaolog.InfusionActivity;
import com.jzr.nursedevice.utils.CommonUtil;

import org.greenrobot.eventbus.EventBus;

public class ScannerBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.jzr.secnner")) {
            String topActivity = CommonUtil.getTopActivity(BaseApplication.getContext());
            String codeData = intent.getStringExtra("data");
            if (topActivity.equals(DoctorActionActivity.class.getName())) {
                CodeDataOfDoctorActionBean codeDataOfDoctorActionBean = new CodeDataOfDoctorActionBean();
                codeDataOfDoctorActionBean.setCodeData(codeData);
                EventBus.getDefault().post(codeDataOfDoctorActionBean);
            }
            if (topActivity.equals(HomeActivity.class.getName())) {
                CodeDataOfHomeBean codeDataOfHomeBean = new CodeDataOfHomeBean();
                codeDataOfHomeBean.setCodeData(codeData);
                EventBus.getDefault().post(codeDataOfHomeBean);
            }
            if (topActivity.equals(InfusionActivity.class.getName())) {
                CodeDataOfInfusionBean codeDataOfInfusionBean = new CodeDataOfInfusionBean();
                codeDataOfInfusionBean.setCodeData(codeData);
                EventBus.getDefault().post(codeDataOfInfusionBean);
            }
        }
    }
}
