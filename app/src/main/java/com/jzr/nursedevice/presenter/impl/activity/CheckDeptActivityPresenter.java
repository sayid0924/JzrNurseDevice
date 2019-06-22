
package com.jzr.nursedevice.presenter.impl.activity;


import com.jzr.nursedevice.api.Api;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.BasePresenter;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.presenter.contract.activity.CheckDeptContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CheckDeptActivityPresenter extends BasePresenter<CheckDeptContract.View> implements CheckDeptContract.Presenter<CheckDeptContract.View> {




    @Override
    public void FetchDeptList(String... s) {
        addSubscrebe(Api.getInstance().FetchDeptList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeptListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DeptListBean data) {

                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchDeptListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
