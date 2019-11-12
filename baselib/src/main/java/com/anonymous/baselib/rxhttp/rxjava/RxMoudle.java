package com.anonymous.baselib.rxhttp.rxjava;

/**
 * @Description: 公共解析类
 * @Author: Anonymous
 * @Time: 2019/8/31 19:31
 */
public class RxMoudle<T> {

    private String desc;
    private int code;
    private long timestamp;
    private T data;
    private int nodataanswer;
    private String serial_no;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getNodataanswer() {
        return nodataanswer;
    }

    public void setNodataanswer(int nodataanswer) {
        this.nodataanswer = nodataanswer;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }
}
