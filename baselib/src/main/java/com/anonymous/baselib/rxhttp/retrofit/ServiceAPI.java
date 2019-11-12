package com.anonymous.baselib.rxhttp.retrofit;

import com.anonymous.baselib.Constants;
import com.anonymous.baselib.rxhttp.https.SSLSocketClient;
import com.anonymous.baselib.rxhttp.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description: 构建Retrofit
 * @Author: Anonymous
 * @Time: 2019/8/31 19:31
 */
public class ServiceAPI {

    private static RetrofitAPI retrofitAPI;

    /**
     * 创建Retrofit
     *
     * @return
     */
    public static RetrofitAPI Retrofit() {
        if (retrofitAPI == null) {
            retrofitAPI = new Retrofit.Builder()
                    .baseUrl(Constants.HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getOkhttpClient())
                    .build()
                    .create(RetrofitAPI.class);
        }
        return retrofitAPI;
    }

    /**
     * 创建Okhttp
     *
     * @return
     */
    public static OkHttpClient getOkhttpClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getTrustManager())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
    }
}
