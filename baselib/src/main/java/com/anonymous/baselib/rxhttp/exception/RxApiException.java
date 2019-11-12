package com.anonymous.baselib.rxhttp.exception;

/**
 * @Description: 异常拦截类
 * @Author: Anonymous
 * @Time: 2019/8/31 19:30
 */
public class RxApiException extends RuntimeException {

    public RxApiException(int resultCode, String message) {
        this(getRxExceptionMessage(resultCode, message));
    }

    public RxApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 对服务器传递过来的特殊信息进行特殊处理
     *
     * @param code
     * @return
     */
    private static String getRxExceptionMessage(int code, String message) {
//        if (code.equals("Y00-000403")) {
//            //Token过期，需要重新登录
//            EventBus.getDefault().post(new TokenLose());
//        }
        return message;
    }
}

