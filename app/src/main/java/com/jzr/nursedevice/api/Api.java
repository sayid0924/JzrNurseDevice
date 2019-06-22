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


import com.google.gson.Gson;
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

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public class Api {

    private static Api instance;
    private ApiService service;

    private Api(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constant.API_BASE_URL)
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance() {
        synchronized (Api.class) {
            if (instance == null)
                instance = new Api(Okhttp.provideOkHttpClient());
            return instance;
        }
    }

     private static Map<String, String> getMap(String... s) {
        Map<String, String> map = new HashMap<>();
        if (s.length % 2 != 0) {
            return null;
        } else {
            for (int i = 0; i < s.length; i++) {
                map.put(s[i], s[++i]);
            }
        }
        return map;
    }

    // 登录
    public Observable<LoginBean> FetchLogin(String... s) {
        return service.FetchLogin(getMap(s));
    }
    // 获取科室列表
    public Observable<DeptListBean> FetchDeptList(String... s) {
        return service.FetchDeptList(getMap(s));
    }
    // 获取病人列表
    public Observable<PatientInfoBean> FetchPatientList(String... s) {
        return service.FetchPatientList(getMap(s));
    }
    // 获取病人医嘱列表
    public Observable<DoctorActionBean> FetchDoctorOrderList(String... s) {
        return service.FetchDoctorOrderList(getMap(s));
    }
    // 执行病人医嘱
    public Observable<ExecActionBean> FetchDoctorOrderExec(String... s) {
        return service.FetchDoctorOrderExec(getMap(s));
    }
    // 取消执行病人医嘱
    public Observable<ExecActionBean> FetchDoctorOrderCancelExec(String... s) {
        return service.FetchDoctorOrderCancelExec(getMap(s));
    }
    // md5加密
    public Observable<ExecActionBean> FetchOpenHelperMd5(String... s) {
        return service.FetchOpenHelperMd5(getMap(s));
    }

    // 绑定输液仪设备接口—新
    public Observable<IonewBindingBean> FetchIonewBinding(IonewBindingBoby ionewBindingBoby) {
        return service.FetchIonewBinding(ionewBindingBoby);
    }

    // 输液仪设备列表
    public Observable<IonewGetdevlistBean> FetchIonewGetdevlist(IonewGetdevlistBoby ionewGetdevlistBoby) {
        return service.FetchIonewGetdevlist(ionewGetdevlistBoby);
    }
    // 病人花费
    public Observable<ChargeInfoBean> FetchPatientChargeInfo(String... s) {
        return service.FetchPatientChargeInfo(getMap(s));
    }
}
