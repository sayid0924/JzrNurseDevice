package com.jzr.nursedevice.ui.activity.setting;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.utils.PreferUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SystemSettingActivity extends BaseActivity {

    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @BindView(R.id.et_ip)
    EditText etIp;
    @BindView(R.id.et_port)
    EditText etPort;
    @BindView(R.id.et_socker_ip)
    EditText etSockerIp;
    @BindView(R.id.et_socker_port)
    EditText etSockerPort;


    @Override
    public int getLayoutId() {
        return R.layout.activity_system_setting;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        leftTitle.setText("系统设置");
        etIp.setText(PreferUtil.getInstance().getDefaultIp());
        etPort.setText(PreferUtil.getInstance().getDefaultPort());
        etSockerIp.setText(PreferUtil.getInstance().getSoketIp());
        etSockerPort.setText(PreferUtil.getInstance().getSoketPort());
    }

    @Override
    protected void onDestroy() {
        PreferUtil.getInstance().setDefaultIp(etIp.getText().toString().trim());
        PreferUtil.getInstance().setDefaultPort(etPort.getText().toString().trim());
        PreferUtil.getInstance().setSocketIp(etSockerIp.getText().toString().trim());
        PreferUtil.getInstance().setSocketPort(etSockerPort.getText().toString().trim());
        super.onDestroy();

    }

    @OnClick({R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }


}
