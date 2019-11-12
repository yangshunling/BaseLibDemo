package com.anonymous.baselib.utils;

import com.tencent.mmkv.MMKV;

/**
 * @Description: CacheUtils
 * @Author: Anonymous
 * @Time: 2019/8/31 17:15
 */
public class CacheUtils {

    private static CacheUtils sUtils;
    private static MMKV mmkv;

    private CacheUtils() {
    }

    public static CacheUtils getInstance() {
        if (sUtils == null)
            sUtils = new CacheUtils();
        if (mmkv == null)
            mmkv = MMKV.defaultMMKV();
        return sUtils;
    }

    public void put(String key, Object value) {
        if (value instanceof String)
            mmkv.encode(key, (String) value);
        if (value instanceof Boolean)
            mmkv.encode(key, (Boolean) value);
        if (value instanceof Integer)
            mmkv.encode(key, (Integer) value);
    }

    public String getString(String key) {
        return mmkv.decodeString(key, "");
    }

    public boolean getBoolean(String key) {
        return mmkv.decodeBool(key, false);
    }

    public int getInt(String key) {
        return mmkv.decodeInt(key, -1);
    }

    public void remove(String key) {
        mmkv.removeValueForKey(key);
    }

    public void clear() {
        mmkv.clearAll();
    }
}
