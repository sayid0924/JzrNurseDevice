
package com.jzr.nursedevice.api;


import android.annotation.SuppressLint;

import com.blankj.utilcode.utils.NetworkUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.LoginBean;
import com.jzr.nursedevice.utils.CommonUtil;
import com.jzr.nursedevice.utils.PreferUtil;
import com.orhanobut.logger.Logger;
import com.jzr.nursedevice.api.persistentcookiejar.PersistentCookieJar;
import com.jzr.nursedevice.api.persistentcookiejar.cache.SetCookieCache;
import com.jzr.nursedevice.api.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.jzr.nursedevice.base.BaseApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;


class Okhttp {

    private static PersistentCookieJar cookieJar;

    static OkHttpClient provideOkHttpClient() {

        //cookie
//        cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApplication.getContext()));
//
//        File httpCacheDir = new File(BaseApplication.getContext().getCacheDir(), "response");
//        int cacheSize = 10 * 1024 * 1024;  //10 MiB
//        Cache cache = new Cache(httpCacheDir, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .retryOnConnectionFailure(true) // 失败重发
//                .cache(cache)
//                .cookieJar(cookieJar)
                .addInterceptor(new TokenInterceptor())
                .addInterceptor(new MoreBaseUrlInterceptor())
                .addInterceptor(BEARER_TOKEN)
                .addInterceptor(new LoggingInterceptor());

        return builder.build();

    }


    private static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();
            Request request = chain.request();
            if (!NetworkUtils.isAvailableByPing()) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isAvailableByPing()) {
                int maxAge = 0;//read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28;//tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Prama")
                        .header("Cache-Control", "poublic, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

    static class LoggingInterceptor implements Interceptor {
        @SuppressLint("DefaultLocale")
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();//请求发起的时间
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < request.url().queryParameterNames().size(); i++) {
                map.put(request.url().queryParameterName(i), request.url().queryParameterValue(i));
            }

            Response response = chain.proceed(request);
            long t2 = System.nanoTime();//收到响应的时间

            ResponseBody responseBody = response.peekBody(1024 * 1024);

            Logger.e(String.format("接收响应: [%s] %n返回json:【%s】%n请求参数: [%s] %n响应时间[%.1fms]",
                    response.request().url(),
                    formatJson(responseBody.string()),
                    transMapToString(map),
                    (t2 - t1) / 1e6d
            ));

            return response;
        }
    }

    static String transMapToString(Map map) {
        Map.Entry entry;
        StringBuilder sb = new StringBuilder();
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            entry = (Map.Entry) iterator.next();
            sb.append(entry.getKey().toString()).append(" == ").append(null == entry.getValue() ? "" :
                    entry.getValue().toString()).append(iterator.hasNext() ? "\n" : "");
        }
        return sb.toString();
    }

    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

    private static Interceptor BEARER_TOKEN = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            List<String> pathSegments = chain.request().url().pathSegments();
            String segments = pathSegments.get(pathSegments.size() - 1);
            if (segments.equals("deptList") || segments.equals("login")) {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            } else {
                String token = PreferUtil.getInstance().getTokenType() + " " + PreferUtil.getInstance().getTokenData();

                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                HttpUrl oldHttpUrl = request.url();

                List<String> headerValues = request.headers(Constant.HEADER_KEY);
                if (headerValues != null && headerValues.size() > 0) {
                    //如果有这个header，先将配置的header删除
                    builder.removeHeader(Constant.HEADER_KEY);
                    //匹配获得新的BaseUrl
                    String headerValue = headerValues.get(0);
                    HttpUrl newBaseUrl = null;
                    if (Constant.INFUSION_KEY.equals(headerValue)) {
                        newBaseUrl = HttpUrl.parse(Constant.INFUSION_BASE_URL);
                    } else {
                        newBaseUrl = oldHttpUrl;
                    }
                    //重建新的HttpUrl，修改需要修改的url部分
                    HttpUrl newFullUrl = oldHttpUrl
                            .newBuilder()
                            .scheme(newBaseUrl.scheme())//更换网络协议
                            .host(newBaseUrl.host())//更换主机名
                            .port(newBaseUrl.port())//更换端口
//                            .removePathSegment(0)//移除第一个参数
                            .build();
                    //重建这个request，通过builder.url(newFullUrl).build()；
                    // 然后返回一个response至此结束修改
                    return chain.proceed(builder.url(newFullUrl).build());
                } else {
                    Request original = chain.request();
                    Request tokenRequest = original.newBuilder()
                            .header("Authorization", token)
                            .method(original.method(), original.body())
                            .build();
//                    builder.addHeader("Authorization", token);
//                    builder.method(request.method(), request.body());
                    return chain.proceed(tokenRequest);
                }
            }
        }
    };

    static class TokenInterceptor implements Interceptor {

        private final Charset UTF8 = Charset.forName("UTF-8");

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            // try the request
            Response originalResponse = chain.proceed(request);
            ResponseBody responseBody = originalResponse.body();

            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = UTF8;

            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            String bodyString = buffer.clone().readString(charset);
            JSONObject jsonObj = null;

            try {
                jsonObj = new JSONObject(bodyString);
                if (jsonObj.has("status")) {
                    int status = jsonObj.optInt("status");
                    if (status == 417 || status == 401) {
                        OkHttpClient client = new OkHttpClient();
                        FormBody.Builder builder = new FormBody.Builder();
                        builder.add("username", PreferUtil.getInstance().getUserName());
                        builder.add("password", PreferUtil.getInstance().getUserPassword());
                        RequestBody requestBody = builder.build();

                        Request tokRequest = new Request.Builder()
                                .url(Constant.API_BASE_URL + Constant.API_USER_LOGIN)
                                .post(requestBody)
                                .build();

                        Call call = client.newCall(tokRequest);
                        Response response = call.execute();
                        String responseStr = response.body().string();
                        LoginBean newToken = new Gson().fromJson(responseStr, LoginBean.class);

                        if (newToken.getData() != null) {
                            HttpUrl originalHttpUrl = request.url();
                            HttpUrl url = originalHttpUrl.newBuilder()
                                    .build();
                            PreferUtil.getInstance().setTokenData(newToken.getData());
                            PreferUtil.getInstance().setTokenType(newToken.getTokenType());

                            Request newRequest = request.newBuilder()
                                    .addHeader("Authorization", newToken.getTokenType() + " " + newToken.getData())
                                    .url(url)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return originalResponse;
        }
    }

    static class MoreBaseUrlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取原始的originalRequest
            Request originalRequest = chain.request();
            //获取老的url
            HttpUrl oldUrl = originalRequest.url();
            //获取originalRequest的创建者builder
            Request.Builder builder = originalRequest.newBuilder();

            HttpUrl baseURL;
//            String strBaseUrl ="http://"+PreferUtil.getInstance().getBaseUrl()+":"+PreferUtil.getInstance().getServerPort();
            baseURL = HttpUrl.parse(CommonUtil.getBaseUrl());
            //重建新的HttpUrl，需要重新设置的url部分

            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())
                    .host(baseURL.host())
                    .port(baseURL.port())
                    .build();
            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).build();
            return  chain.proceed(newRequest);
        }
    }
}