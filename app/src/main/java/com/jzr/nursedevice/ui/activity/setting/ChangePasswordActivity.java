package com.jzr.nursedevice.ui.activity.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePasswordActivity extends BaseActivity {



    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;


    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        actionbarTitle.setText("修改密码");

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
