package com.anonymous.baselib.rxhttp.rxjava;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Description: VeGa
 * @Author: Anonymous
 * @Time: 2019-05-09 14:52
 */
public class RxHelper {

    public static <T> Observable<T> observer(Observable<RxMoudle<T>> observable) {
        return observable
                .map(new RxResultFunc<T>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
