package com.anonymous.baselib.rxhttp.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Anonymous on 2017/8/22.
 */

public class RxObservable<T> extends Observable<T> implements ObservableTransformer<RxMoudle<T>, T> {

    @Override
    public ObservableSource<T> apply(Observable<RxMoudle<T>> rxMoudleObservable) {
        return rxMoudleObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new RxResultFunc<T>());
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {

    }
}

