
package com.jzr.nursedevice.presenter.impl.fragment;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.presenter.contract.fragment.PatientInfoContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PatientInfoFragmentPresenter extends BasePresenter<PatientInfoContract.View> implements PatientInfoContract.Presenter<PatientInfoContract.View> {


    @Override
    public void FetchPatientList(String... s) {
        addSubscrebe(Api.getInstance().FetchPatientList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PatientInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(PatientInfoBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchPatientListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
