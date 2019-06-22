package com.jzr.nursedevice.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class CommonUtil {



    public static String getBaseUrl() {
        return "http://" + PreferUtil.getInstance().getDefaultIp() + ":" + PreferUtil.getInstance().getDefaultPort();
    }

    //判断当前界面显示的是哪个Activity
    public static String getTopActivity(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        Log.d("Chunna.zheng", "pkg:" + cn.getPackageName());//包名
        Log.d("Chunna.zheng", "cls:" + cn.getClassName());//包名加类名
        return cn.getClassName();
    }


    /***
     * 获取本机IP地址
     */
    public static String getIP() {

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 获取设备唯一标识
     */
    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceCode = telephonyManager.getDeviceId();

        if (deviceCode == null) {
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            deviceCode = info.getMacAddress();
        }
        if (deviceCode == null) {
            deviceCode = System.currentTimeMillis() + "";
        }
//        Logger.e("=============    DeviceId:   =========== " +deviceCode);
        return deviceCode;
    }


    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     *
     * @param content
     *            传入的字符串
     * @param frontNum
     *            保留前面字符的位数
     * @param endNum
     *            保留后面字符的位数
     * @return 带星号的字符串
     */
    public static String replaceString2Star(String content, int frontNum, int endNum) {
        if (content == null || content.trim().isEmpty())
            return content;

        int len = content.length();

        if (frontNum >= len || frontNum < 0 || endNum >= len || endNum < 0)
            return content;

        if (frontNum + endNum >= len)
            return content;

        int beginIndex = frontNum;
        int endIndex = len - endNum;
        char[] cardChar = content.toCharArray();

        for (int j = beginIndex; j < endIndex; j++) {
            cardChar[j] = '*';
        }

        return new String(cardChar);
    }

}
