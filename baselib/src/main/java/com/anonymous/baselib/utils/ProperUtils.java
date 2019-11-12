package com.anonymous.baselib.utils;

import android.content.Context;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: ProperUtils
 * @Author: Anonymous
 * @Time: 2019/8/31 18:51
 */
public class ProperUtils {
    public static Properties getProperties(Context c) {
        Properties props = new Properties();
        try {
            InputStream in = c.getAssets().open("ZRCPayConfig");
            props.load(in);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return props;
    }
}
