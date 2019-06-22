
package com.jzr.nursedevice.presenter.contract.activity;


import com.jzr.nursedevice.base.BaseContract;

public interface MainContract {

    interface View extends BaseContract.BaseView {
        /**
         * 建立与融云服务器的连接成功
         */
        void connectSuccess();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 建立与融云服务器的连接
         */
        void connect(String ...s);

    }
}
