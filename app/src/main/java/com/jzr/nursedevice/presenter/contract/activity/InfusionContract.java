
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;
import com.jzr.nursedevice.bean.ionew.IonewGetdevlistBean;
import com.jzr.nursedevice.bean.ionew.boby.IonewBindingBoby;
import com.jzr.nursedevice.bean.ionew.boby.IonewGetdevlistBoby;

public interface InfusionContract {

    interface View extends BaseContract.BaseView {
        /**
         * 绑定输液仪设备接口—新
         */
        void FetchIonewBindingSuccess();

        /**
         * 输液仪设备列表
         */
        void FetchIonewGetdevlistSuccess(IonewGetdevlistBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 绑定输液仪设备接口—新
         */
        void FetchIonewBinding(IonewBindingBoby ionewBindingBoby);

        /**
         * 输液仪设备列表—新
         */
        void FetchIonewGetdevlist(IonewGetdevlistBoby ionewGetdevlistBoby);

    }
}
