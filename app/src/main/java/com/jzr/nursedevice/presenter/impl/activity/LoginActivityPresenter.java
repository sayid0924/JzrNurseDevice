
package com.jzr.nursedevice.presenter.impl.activity;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.presenter.contract.activity.LoginContract;
import com.jzr.nursedevice.presenter.contract.activity.MainContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivityPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {



    @Override
    public void FetchLogin(String... s) {

        addSubscrebe(Api.getInstance().FetchLogin(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(LoginBean data) {

                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchLoginSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
