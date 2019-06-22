/**
 * Copyright(C)2012-2013 深圳市掌星立意科技有限公司版权所有
 * 创 建 人:Jacky
 * 修 改 人:
 * 创 建日期:2013-7-25
 * 描    述:xml储存数据
 * 版 本 号:
 */
package com.jzr.nursedevice.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseApplication;


public final class PreferUtil {

    private static Context context;

    public static PreferUtil INSTANCE;
    private static SharedPreferences mPrefer;
    private static final String APP_NAME = "com.jzr.nursedevice";

    private static final String DEPT_POSITION = "dept_position";
    private static final String DEPT_CODE = "dept_code";
    private static final String USER_NAME = "user_name";
    private static final String USER_PASSWORD = "user_password";
    private static final String RECORD_PASSWORD = "record_password";
    private static final String AUTOMATIC_LOGIN = "automatic_login";

    private static final String TOKEN_TYPE = "token_type";
    private static final String TOKEN_DATA = "token_data";

    private static final String DEFAULT_IP = "default_ip";
    private static final String DEFAULT_PORT = "default_port";

    private static final String SOCKET_PORT = "socket_port";
    private static final String SOCKET_IP = "socket_ip";


    public void setSocketPort(String fag) {
        putString(SOCKET_PORT, fag);
    }

    public String getSoketPort() {
        return getString(SOCKET_PORT, context.getResources().getString(R.string.socket_port));
    }

    public void setSocketIp(String fag) {
        putString(SOCKET_IP, fag);
    }

    public String getSoketIp() {
        return getString(SOCKET_IP, context.getResources().getString(R.string.socket_ip));
    }

    public void setDefaultPort(String fag) {
        putString(DEFAULT_PORT, fag);
    }

    public String getDefaultPort() {
        return getString(DEFAULT_PORT, context.getResources().getString(R.string.default_port));
    }

    public void setDefaultIp(String fag) {
        putString(DEFAULT_IP, fag);
    }

    public String getDefaultIp() {
        return getString(DEFAULT_IP, context.getResources().getString(R.string.default_ip));
    }

    public void setTokenData(String fag) {
        putString(TOKEN_DATA, fag);
    }

    public String getTokenData() {
        return getString(TOKEN_DATA, "");
    }


    public void setTokenType(String fag) {
        putString(TOKEN_TYPE, fag);
    }

    public String getTokenType() {
        return getString(TOKEN_TYPE, "");
    }


    public void setAutomaticLogin(boolean fag) {
        putBoolean(AUTOMATIC_LOGIN, fag);
    }

    public boolean getAutomaticLogin() {
        return getBoolean(AUTOMATIC_LOGIN, false);
    }


    public void setRecordPassword(boolean fag) {
        putBoolean(RECORD_PASSWORD, fag);
    }

    public boolean getRecordPassword() {
        return getBoolean(RECORD_PASSWORD, false);
    }


    public void setUserPassword(String fag) {
        putString(USER_PASSWORD, fag);
    }

    public String getUserPassword() {
        return getString(USER_PASSWORD, "");
    }

    public void setUserName(String fag) {
        putString(USER_NAME, fag);
    }

    public String getUserName() {
        return getString(USER_NAME, "");
    }


    public void setDeptPosition(String fag) {
        putString(DEPT_POSITION, fag);
    }

    public String getDeptPosition() {
        return getString(DEPT_POSITION, "");
    }

    public void setDeptCode(String fag) {
        putString(DEPT_CODE, fag);
    }

    public String getDeptCode() {
        return getString(DEPT_CODE, "");
    }


    private PreferUtil() {
    }

    public static PreferUtil getInstance() {
        if (INSTANCE == null) {
            context = BaseApplication.getContext();
            return new PreferUtil();
        }
        return INSTANCE;
    }

    public void init(Context ctx) {
        mPrefer = ctx.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE
                | Context.MODE_PRIVATE);
        mPrefer.edit().commit();
    }

    public String getString(String key, String defValue) {
        return mPrefer.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mPrefer.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefer.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mPrefer.edit().putString(key, value).commit();
    }

    public void putInt(String key, int value) {
        mPrefer.edit().putInt(key, value).commit();
    }

    public void putBoolean(String key, boolean value) {
        mPrefer.edit().putBoolean(key, value).commit();
    }

    public void putLong(String key, long value) {
        mPrefer.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mPrefer.getLong(key, defValue);
    }

    public void removeKey(String key) {
        mPrefer.edit().remove(key).commit();
    }


}
