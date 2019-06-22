
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.DeptListBean;

public interface CheckDeptContract {

    interface View extends BaseContract.BaseView {


        void FetchDeptListSuccess(DeptListBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void FetchDeptList(String... s);
    }
}
