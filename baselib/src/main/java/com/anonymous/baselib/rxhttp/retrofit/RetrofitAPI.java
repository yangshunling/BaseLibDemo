package com.anonymous.baselib.rxhttp.retrofit;

import com.anonymous.baselib.LoginEntity;
import com.anonymous.baselib.rxhttp.rxjava.RxMoudle;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Description: API接口
 * @Author: Anonymous
 * @Time: 2019/8/31 19:28
 */
public interface RetrofitAPI {

    /**
     * 用户登录
     */
    @FormUrlEncoded
    @POST("smartwhale/message")
    Observable<RxMoudle<LoginEntity>> userLogin(@FieldMap Map<String, String> params);
}
