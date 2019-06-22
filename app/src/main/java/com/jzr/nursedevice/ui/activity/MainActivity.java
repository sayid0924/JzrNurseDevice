package com.jzr.nursedevice.ui.activity;

import com.blankj.utilcode.utils.ToastUtils;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.presenter.contract.activity.MainContract;
import com.jzr.nursedevice.presenter.impl.activity.MainActivityPresenter;

public class MainActivity extends BaseActivity implements MainContract.View {

    MainActivityPresenter mPresenter = new MainActivityPresenter();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
        mPresenter.detachView();
    }

    @Override
    public void initView() {
        mPresenter.connect("account", "15118183011", "password", "000000");
    }

    @Override
    public void connectSuccess() {
        ToastUtils.showLongToast("VVVVVV");
    }

    @Override
    public void showError(String message) {

    }

}
