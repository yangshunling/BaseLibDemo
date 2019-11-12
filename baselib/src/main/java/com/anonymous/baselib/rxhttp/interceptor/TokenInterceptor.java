package com.anonymous.baselib.rxhttp.interceptor;

import android.util.Log;

import com.anonymous.baselib.utils.CacheUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Description: 公共参数拦截器
 * @Author: Anonymous
 * @Time: 2019/8/31 19:30
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        String token = CacheUtils.getInstance().getString("token");
        Log.v("token", token);
        if (token.equals("")) {
            return chain.proceed(original);
        }
        Request request = original.newBuilder()
                .header("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(request);
    }
}
