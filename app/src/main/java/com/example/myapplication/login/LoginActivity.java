package com.example.myapplication.login;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anonymous.baselib.LoginEntity;
import com.anonymous.baselib.base.BaseActivity;
import com.example.myapplication.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @Description: LoginActivity
 * @Author: Anonymous
 * @Time: 2019/8/31 18:25
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        // TODO: Presenter事件接管
        mPresenter.login(getUserName(), getPassword());
    }

    @Override
    public void onSuccess(LoginEntity entity) {
        // TODO: 数据回调处理
        Logger.v(entity.getToken());
    }

    private String getUserName() {
        return mUsername.getText().toString().trim();
    }

    private String getPassword() {
        return mPassword.getText().toString().trim();
    }

}
