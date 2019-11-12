package com.anonymous.baselib.base;

/**
 * @Description: BasePresenter
 * @Author: Anonymous
 * @Time: 2019/8/31 18:36
 */
public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
