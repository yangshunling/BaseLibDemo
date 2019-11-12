package com.anonymous.baselib.base;

/**
 * @Description: BasePresenterImpl
 * @Author: Anonymous
 * @Time: 2019/8/31 18:36
 */
public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    protected V mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
