
package com.jzr.nursedevice.presenter.impl.activity;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.presenter.contract.activity.MainContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {


    @Override
    public void connect(String... s) {
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
                        if (mView != null && data != null) {
                        }
                    }
                }));
    }
}
