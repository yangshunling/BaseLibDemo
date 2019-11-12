package com.anonymous.baselib.component;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @Description: RxTimer
 * @Author: Anonymous
 * @Time: 2019/8/31 16:34
 */
public class RxTimer {

    private Disposable mDisposable;

    /**
     * 延迟操作
     *
     * @param milliSeconds 延迟时间
     * @param rxAction     执行事件
     */
    public void timer(long milliSeconds, final RxAction rxAction) {
        Observable.timer(milliSeconds, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(Long number) {
                        if (rxAction != null) {
                            rxAction.action(number);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //取消订阅
                        cancel();
                    }

                    @Override
                    public void onComplete() {
                        //取消订阅
                        cancel();
                    }
                });
    }

    /**
     * 间隔操作
     *
     * @param milliSeconds 间隔时间
     * @param rxAction     执行事件
     */
    public void interval(long milliSeconds, final RxAction rxAction) {
        Observable.interval(milliSeconds, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(Long number) {
                        if (rxAction != null) {
                            rxAction.action(number);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 取消订阅
     */
    public void cancel() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    /**
     * 事件执行接口
     */
    public interface RxAction {
        void action(long number);
    }
}
