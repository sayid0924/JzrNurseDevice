package com.jzr.nursedevice.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.ui.activity.HomeActivity;
import com.jzr.nursedevice.ui.activity.setting.ChangePasswordActivity;
import com.jzr.nursedevice.ui.activity.setting.DeptTemActivity;
import com.jzr.nursedevice.ui.activity.setting.ReportActivity;
import com.jzr.nursedevice.ui.activity.setting.SystemSettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingFragment extends BaseFragment {

    private static SettingFragment nurseInfoFragment;

    @BindView(R.id.ll_change_password)
    LinearLayout llChangePassword;

    @BindView(R.id.ll_system_setting)
    LinearLayout llSystemSetting;

    @BindView(R.id.ll_tem)
    LinearLayout llTem;
    @BindView(R.id.ll_sign)
    LinearLayout llSign;
    @BindView(R.id.ll_patrol)
    LinearLayout llPatrol;
    @BindView(R.id.ll_report)
    LinearLayout llReport;

    public static SettingFragment newInstance() {
        nurseInfoFragment = new SettingFragment();
        return nurseInfoFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void attachView() {

    }


    @OnClick({R.id.ll_change_password, R.id.ll_system_setting, R.id.ll_tem,R.id.ll_sign,R.id.ll_patrol,R.id.ll_report})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_change_password:  //  修改密码
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), ChangePasswordActivity.class), getSupportActivity());
                break;
            case R.id.ll_system_setting:   //  系统设置
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), SystemSettingActivity.class), getSupportActivity());
                break;
            case R.id.ll_tem:     // 全科体温
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), DeptTemActivity.class), getSupportActivity());
                break;
            case R.id.ll_sign:     // 全科体征
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), DeptTemActivity.class), getSupportActivity());
                break;
            case R.id.ll_patrol:     // 全科巡房
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), DeptTemActivity.class), getSupportActivity());
                break;
            case R.id.ll_report:     // 交班本
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), ReportActivity.class), getSupportActivity());
                break;
        }
    }


}
