
package com.jzr.nursedevice.presenter.impl.activity;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.ChargeInfoBean;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.presenter.contract.activity.PatientDetailsContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PatientDetailsActivityPresenter extends BasePresenter<PatientDetailsContract.View> implements PatientDetailsContract.Presenter<PatientDetailsContract.View> {

    @Override
    public void FetchPatientChargeInfo(String... s) {
        addSubscrebe(Api.getInstance().FetchPatientChargeInfo(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChargeInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mView != null)
                            mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ChargeInfoBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchPatientChargeInfoSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
