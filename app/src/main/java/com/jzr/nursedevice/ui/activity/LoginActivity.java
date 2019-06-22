package com.jzr.nursedevice.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.EmptyUtils;
import com.blankj.utilcode.utils.EncryptUtils;
import com.blankj.utilcode.utils.SPUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.CheckDeptBean;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.presenter.contract.activity.LoginContract;
import com.jzr.nursedevice.presenter.impl.activity.LoginActivityPresenter;
import com.jzr.nursedevice.ui.activity.setting.SystemSettingActivity;
import com.jzr.nursedevice.utils.PreferUtil;

import org.greenrobot.eventbus.Subscribe;

import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.PUT;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    private LoginActivityPresenter presenter = new LoginActivityPresenter();

    private String userName;
    private String userPassword;

    @BindView(R.id.user_login)
    Button userLogin;
    @BindView(R.id.inpatient_area_name)
    TextView tvAreaName;
    @BindView(R.id.user_name)
    EditText etUserName;
    @BindView(R.id.user_password)
    EditText etUserPassword;
    @BindView(R.id.cb_record_password)
    CheckBox cbRecordPassword;
    @BindView(R.id.cb_automatic_login)
    CheckBox cbAutomaticLogin;
    @BindView(R.id.rl_check_dept)
    RelativeLayout rlCheckDept;
    @BindView(R.id.iv_settings)
    ImageView ivSettings;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
        setSwipeBackEnable(false);

        if (PreferUtil.getInstance().getAutomaticLogin()) {
            this.finish();
            startActivityIn(new Intent(this, HomeActivity.class), this);
        }

        tvAreaName.setText(PreferUtil.getInstance().getDeptPosition());
        etUserName.setText(PreferUtil.getInstance().getUserName());
        etUserPassword.setText(PreferUtil.getInstance().getUserPassword());

        cbRecordPassword.setChecked(PreferUtil.getInstance().getRecordPassword());
        cbAutomaticLogin.setChecked(PreferUtil.getInstance().getAutomaticLogin());

    }

    @OnClick({R.id.user_login, R.id.rl_check_dept,R.id.iv_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_login:
                // 登录
                userName = etUserName.getText().toString().trim();
                if (EmptyUtils.isEmpty(userName)) {
                    ToastUtils.showLongToast("请输入账号");
                    break;
                }
                userPassword = etUserPassword.getText().toString().trim();
                if (EmptyUtils.isEmpty(userPassword)) {
                    ToastUtils.showLongToast("请输入密码");
                    break;
                }
                if (EmptyUtils.isEmpty(tvAreaName.getText().toString().trim())) {
                    ToastUtils.showLongToast("请选择科室");
                    break;
                }

                PreferUtil.getInstance().setRecordPassword(cbRecordPassword.isChecked());
                PreferUtil.getInstance().setAutomaticLogin(cbAutomaticLogin.isChecked());
                presenter.FetchLogin("username", userName, "password", EncryptUtils.encryptMD5ToString(userPassword));
                showWaitingDialog("正在登陆中......");

                break;
            case R.id.rl_check_dept:
                // 选择科室
                userName = etUserName.getText().toString().trim();
                if (EmptyUtils.isEmpty(userName)) {
                    ToastUtils.showLongToast("请输入账号");
                    break;
                }

                Intent intent = new Intent(this, CheckDeptActivity.class);
                intent.putExtra("userCode", userName);
                startActivityIn(intent, this);

                break;

            case R.id.iv_settings:
                startActivityIn(new Intent(this,SystemSettingActivity.class), this);
                break;
        }
    }

    @Subscribe
    public void getEventBus(DeptListBean.DataBean item) {

        tvAreaName.setText(item.getName());
        PreferUtil.getInstance().setDeptCode(item.getCode());
        PreferUtil.getInstance().setDeptPosition(item.getName());

    }

    @Override
    public void FetchLoginSuccess(LoginBean data) {

        hideWaitingDialog();
        PreferUtil.getInstance().setTokenType(data.getTokenType());
        PreferUtil.getInstance().setTokenData(data.getData());
        PreferUtil.getInstance().setUserPassword(userPassword);
        PreferUtil.getInstance().setUserName(userName);
        finish();
        startActivityIn(new Intent(this, HomeActivity.class), this);
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

}
