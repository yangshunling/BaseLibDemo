package com.anonymous.baselib.base;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.tencent.mmkv.MMKV;

/**
 * @Description: BaseApplication
 * @Author: Anonymous
 * @Time: 2019/8/31 17:51
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initMMKV();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder()
                // 是否显示线程信,默认值true
                .showThreadInfo(true)
                // 要显示的方法行数,默认值2
                .methodCount(2)
                // 隐藏内部方法调用到偏移量,默认值5
                .methodOffset(5)
                // 每个日志的全局标记
                .tag("log")
                .build()));
    }

    private void initMMKV() {
        MMKV.initialize(this);
    }
}
