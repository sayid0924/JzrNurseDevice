
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;

import rx.Observable;

public interface DoctorActionContract {

    interface View extends BaseContract.BaseView {
        /**
         * 获取病人医嘱列表
         */
        void FetchDoctorOrderListSuccess(DoctorActionBean doctorActionBean);

        /**
         * 执行病人医嘱
         */
        void FetchDoctorOrderExecSuccess(ExecActionBean execActionBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 获取病人医嘱列表
         */
        void FetchDoctorOrderList(String... s);

        /**
         * 执行病人医嘱
         */
        void FetchDoctorOrderExec(String... s);

    }
}
