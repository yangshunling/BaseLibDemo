package com.example.myapplication.login;

import com.anonymous.baselib.LoginEntity;
import com.anonymous.baselib.base.BasePresenter;
import com.anonymous.baselib.base.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */
public class LoginContract {

    /******************* View Interface *******************/
    interface View extends BaseView {
        void onSuccess(LoginEntity entity);
    }

    /**************** Presenter Interface ****************/
    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
    }
}
