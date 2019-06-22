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
package com.jzr.nursedevice.api;


import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.ChargeInfoBean;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.ExecActionBean;
import com.jzr.nursedevice.bean.ionew.IonewBindingBean;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.bean.ionew.IonewGetdevlistBean;
import com.jzr.nursedevice.bean.ionew.boby.IonewBindingBoby;
import com.jzr.nursedevice.bean.ionew.boby.IonewGetdevlistBoby;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ApiService {


    /**
     * 会员登录
     */
    @POST(Constant.API_USER_LOGIN)
    Observable<LoginBean> FetchLogin(@QueryMap Map<String, String> map);

    /**
     * 获取科室列表
     */
    @GET(Constant.API_USER_DEPTLIST)
    Observable<DeptListBean> FetchDeptList(@QueryMap Map<String, String> map);

    /**
     * 获取病人列表
     */
    @GET(Constant.API_PATIENT_LIST)
    Observable<PatientInfoBean> FetchPatientList(@QueryMap Map<String, String> map);


    /**
     * 获取病人医嘱列表
     */
    @GET(Constant.API_DOCTORORDER_LIST)
    Observable<DoctorActionBean> FetchDoctorOrderList(@QueryMap Map<String, String> map);


    /**
     * 执行病人医嘱
     */
    @POST(Constant.API_DOCTORORDER_EXEC)
    Observable<ExecActionBean> FetchDoctorOrderExec(@QueryMap Map<String, String> map);

    /**
     * 取消执行病人医嘱
     */
    @POST(Constant.API_DOCTORORDER_CANCELEXEC)
    Observable<ExecActionBean> FetchDoctorOrderCancelExec(@QueryMap Map<String, String> map);

    /**
     * md5加密
     */
    @POST(Constant.OPEN_HELPER_MD5)
    Observable<ExecActionBean> FetchOpenHelperMd5(@QueryMap Map<String, String> map);

    /**
     * 绑定输液仪设备接口—新
     */
    @Headers({"url_type:infusion_key"})
    @POST(Constant.API_IONEW_BINDING)
    Observable<IonewBindingBean> FetchIonewBinding(@Body IonewBindingBoby ionewBindingBoby);

    /**
     * 输液仪设备列表
     */
    @Headers({"url_type:infusion_key"})
    @POST(Constant.API_IONEW_GETDEVLIST)
    Observable<IonewGetdevlistBean> FetchIonewGetdevlist(@Body IonewGetdevlistBoby ionewGetdevlistBoby);

    /**
     * 病人花费
     */
    @GET(Constant.API_PATIENT_CHARGEINFO)
    Observable<ChargeInfoBean> FetchPatientChargeInfo(@QueryMap Map<String, String> map);


}