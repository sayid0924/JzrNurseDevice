package com.jzr.nursedevice.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.blankj.utilcode.utils.Utils;
import com.jzr.nursedevice.utils.GreenDaoUtil;
import com.jzr.nursedevice.utils.PreferUtil;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


public class BaseApplication extends Application {

    private static Context mContext;//上下文

    /**
     * 获取BaseApplication实例
     *
     * @return
     */
    public static ThreadPoolUtils MAIN_EXECUTOR = new ThreadPoolUtils(ThreadPoolUtils.Type.FixedThread, 5);

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initLogger();
        Utils.init(this);
        PreferUtil.getInstance().init(this);
//        CrashHandler.getInstance(this).init();
        GreenDaoUtil.initDataBase(getApplicationContext());

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initLogger() {
        Logger.init("ART").methodCount(2).methodOffset(0).logLevel(LogLevel.FULL).hideThreadInfo();
    }

}
