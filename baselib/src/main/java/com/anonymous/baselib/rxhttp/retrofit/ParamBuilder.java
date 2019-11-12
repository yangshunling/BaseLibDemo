package com.anonymous.baselib.rxhttp.retrofit;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @Description: 参数构造器
 * @Author: Anonymous
 * @Time: 2019/8/31 19:20
 */
public class ParamBuilder {
    private static ParamBuilder mParameterBuilder;
    private static Map<String, String> params;
    private static Map<String, RequestBody> paramBody;

    /**
     * 构建私有方法
     */
    private ParamBuilder() {

    }

    /**
     * 初始化Param参数对象
     */
    public static ParamBuilder newParams() {
        if (mParameterBuilder == null) {
            mParameterBuilder = new ParamBuilder();
        }
        params = new HashMap<>();
        return mParameterBuilder;
    }

    /**
     * 初始化Body参数对象
     */
    public static ParamBuilder newBody() {
        if (mParameterBuilder == null) {
            mParameterBuilder = new ParamBuilder();
        }
        paramBody = new HashMap<>();
        return mParameterBuilder;
    }

    /**
     * 添加Param参数
     */
    public ParamBuilder addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    /**
     * 添加Body参数
     */
    public ParamBuilder addBody(String key, Object o) {
        if (o instanceof String) {
            RequestBody body = RequestBody.create((String) o, MediaType.parse("text/plain"));
            paramBody.put(key, body);
        } else if (o instanceof File) {
            RequestBody body = RequestBody.create((File) o, MediaType.parse("multipart/form-data;charset=UTF-8"));
            paramBody.put(key + "\"; filename=\"" + ((File) o).getName() + "", body);
        }
        return this;
    }

    /**
     * 构建Param
     */
    public Map<String, String> buildParam() {
        return params;
    }

    /**
     * 构建Body
     */
    public Map<String, RequestBody> buildBody() {
        return paramBody;
    }
}
