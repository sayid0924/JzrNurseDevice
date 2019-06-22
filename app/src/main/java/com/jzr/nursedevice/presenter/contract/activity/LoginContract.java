
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.LoginBean;

public interface LoginContract {

    interface View extends BaseContract.BaseView {


        void FetchLoginSuccess(LoginBean data);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void FetchLogin(String... s);
    }
}
