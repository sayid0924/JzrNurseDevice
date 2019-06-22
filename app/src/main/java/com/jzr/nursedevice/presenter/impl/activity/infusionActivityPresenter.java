
package com.jzr.nursedevice.presenter.impl.activity;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.ionew.IonewBindingBean;
import com.jzr.nursedevice.bean.ionew.IonewGetdevlistBean;
import com.jzr.nursedevice.bean.ionew.boby.IonewBindingBoby;
import com.jzr.nursedevice.bean.ionew.boby.IonewGetdevlistBoby;
import com.jzr.nursedevice.presenter.contract.activity.InfusionContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class infusionActivityPresenter extends BasePresenter<InfusionContract.View> implements InfusionContract.Presenter<InfusionContract.View> {


    @Override
    public void FetchIonewBinding(IonewBindingBoby ionewBindingBoby) {
        addSubscrebe(Api.getInstance().FetchIonewBinding(ionewBindingBoby).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IonewBindingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(IonewBindingBean data) {
                        if (mView != null && data != null && data.getResult() == 1) {
                            mView.FetchIonewBindingSuccess();
                        } else {
                            if (mView != null && data != null) {
                                mView.showError(data.getMessage());
                            }
                        }
                    }
                }));
    }

    @Override
    public void FetchIonewGetdevlist(IonewGetdevlistBoby ionewGetdevlistBoby) {
        addSubscrebe(Api.getInstance().FetchIonewGetdevlist(ionewGetdevlistBoby).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IonewGetdevlistBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(IonewGetdevlistBean data) {
                        if (mView != null && data != null && data.getResult() == 1) {
                            mView.FetchIonewGetdevlistSuccess(data);
                        } else {
                            if (mView != null && data != null) {
                                mView.showError(data.getMessage());
                            }
                        }
                    }
                }));
    }
}
