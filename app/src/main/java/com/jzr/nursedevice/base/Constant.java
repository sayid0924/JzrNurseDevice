/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jzr.nursedevice.base;

public class Constant {
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;

    public static boolean canPickupVoip = true;

    //生产环境
    public static  String HEADER_KEY="url_type";
    public static  String INFUSION_KEY="infusion_key";

    public static final String API_BASE_URL = "http://192.168.1.9:8020/";
    public static final String INFUSION_BASE_URL = "http://192.168.1.11:86/";
    public static final String BaseImgUrl = "http://yspsj.885505.com";


     //登录
    public static final String API_USER_LOGIN = "api/user/login";
     //token刷新
    public static final String API_USER_REFESH = "api/user/refesh";
     //获取科室列表
    public static final String API_USER_DEPTLIST = "api/user/deptList";
     //获取病人列表
    public static final String API_PATIENT_LIST = "api/patient/list";
     //获取病人医嘱列表
    public static final String API_DOCTORORDER_LIST = "api/doctorOrder/list";
     //执行医嘱
    public static final String API_DOCTORORDER_EXEC = "api/doctorOrder/exec";
     //取消执行医嘱
    public static final String API_DOCTORORDER_CANCELEXEC = "api/doctorOrder/cancelExec";
     //md5加密
    public static final String OPEN_HELPER_MD5 = "open/helper/md5";
     //绑定输液仪设备接口—新
    public static final String API_IONEW_BINDING = "api/ionew/binding";
     //输液仪设备列表
    public static final String API_IONEW_GETDEVLIST = "api/ionew/GetDevList";
     //病人花费
    public static final String API_PATIENT_CHARGEINFO = "api/patient/chargeInfo";

}
