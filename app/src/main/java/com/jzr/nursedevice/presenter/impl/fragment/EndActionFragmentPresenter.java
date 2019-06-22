
package com.jzr.nursedevice.presenter.impl.fragment;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.presenter.contract.fragment.EndActionContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EndActionFragmentPresenter extends BasePresenter<EndActionContract.View> implements EndActionContract.Presenter<EndActionContract.View> {


    @Override
    public void FetchDoctorOrderList(String... s) {
        addSubscrebe(Api.getInstance().FetchDoctorOrderList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DoctorActionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DoctorActionBean data) {

                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchDoctorOrderListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }

    @Override
    public void FetchDoctorOrderCancelExec(String... s) {
        addSubscrebe(Api.getInstance().FetchDoctorOrderCancelExec(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExecActionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ExecActionBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchDoctorOrderCancelExecSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
