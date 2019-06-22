
package com.jzr.nursedevice.presenter.contract.fragment;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.PatientInfoBean;

public interface PatientInfoContract {

    interface View extends BaseContract.BaseView {

        void FetchPatientListSuccess(PatientInfoBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void FetchPatientList(String... s);

    }
}
