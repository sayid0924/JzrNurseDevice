
package com.jzr.nursedevice.presenter.contract.fragment;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;

public interface NoActionContract {

    interface View extends BaseContract.BaseView {

        void FetchDoctorOrderListSuccess(DoctorActionBean doctorActionBean);

        /**
         * 执行病人医嘱
         */
        void FetchDoctorOrderExecSuccess(ExecActionBean execActionBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void FetchDoctorOrderList(String... s);
        /**
         * 执行病人医嘱
         */
        void FetchDoctorOrderExec(String... s);

    }
}
