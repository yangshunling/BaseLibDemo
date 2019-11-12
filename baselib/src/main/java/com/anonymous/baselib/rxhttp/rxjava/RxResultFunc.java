package com.anonymous.baselib.rxhttp.rxjava;

import com.anonymous.baselib.rxhttp.exception.RxApiException;
import com.orhanobut.logger.Logger;

import io.reactivex.functions.Function;

/**
 * @Description: RxResultFunc
 * @Author: Anonymous
 * @Time: 2019/8/31 19:42
 */
public class RxResultFunc<T> implements Function<RxMoudle<T>, T> {

    @Override
    public T apply(RxMoudle<T> httpResult) throws Exception {
        if (httpResult.getCode() != 0) {
            throw new RxApiException(httpResult.getCode(), httpResult.getDesc());
        }
        return httpResult.getData();
    }
}

