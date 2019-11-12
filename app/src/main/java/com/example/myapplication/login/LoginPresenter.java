package com.example.myapplication.login;

import com.anonymous.baselib.LoginEntity;
import com.anonymous.baselib.base.BasePresenterImpl;
import com.anonymous.baselib.rxhttp.retrofit.ParamBuilder;
import com.anonymous.baselib.rxhttp.retrofit.ServiceAPI;
import com.anonymous.baselib.rxhttp.rxjava.RxHelper;
import com.anonymous.baselib.rxhttp.rxjava.RxSubscriber;

/**
 * @Description: LoginPresenter
 * @Author: Anonymous
 * @Time: 2019/9/23 13:10
 */
public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void login(String username, String password) {
        // 数据请求
        RxHelper.observer(ServiceAPI.Retrofit().userLogin(ParamBuilder.newParams()
                .addParam("username", username)
                .addParam("password", password)
                .buildParam()))
                .subscribe(new RxSubscriber<LoginEntity>() {
                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        // view通知页面更新
                        mView.onSuccess(loginEntity);
                    }
                });
    }
}
