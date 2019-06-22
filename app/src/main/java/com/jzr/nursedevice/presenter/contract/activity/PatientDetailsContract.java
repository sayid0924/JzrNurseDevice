
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.ChargeInfoBean;

import rx.Observable;

public interface PatientDetailsContract {

    interface View extends BaseContract.BaseView {
        /**
         * 病人花费
         */
        void FetchPatientChargeInfoSuccess(ChargeInfoBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 病人花费
         */
        void FetchPatientChargeInfo(String ...s);

    }
}
