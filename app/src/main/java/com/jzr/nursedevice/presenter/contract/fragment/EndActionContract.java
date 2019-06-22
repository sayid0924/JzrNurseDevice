
package com.jzr.nursedevice.presenter.contract.fragment;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;

public interface EndActionContract {

    interface View extends BaseContract.BaseView {

        void FetchDoctorOrderListSuccess(DoctorActionBean doctorActionBean);

        void  FetchDoctorOrderCancelExecSuccess(ExecActionBean execActionBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void FetchDoctorOrderList(String... s);

        void FetchDoctorOrderCancelExec(String... s);


    }
}
