package org.djh.mall.common;

import org.djh.mall.exception.MallExceptionEnum;

/**
 * @author alex1024duan
 */
public class ApiRestResponse<T> {

    public static final Integer OK_STATUS = 10000;
    public static final  String OK_MSG = "SUCCESS";

    private final Integer status;
    private final String msg;
    private final T data;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public ApiRestResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>(OK_STATUS, OK_MSG, null);
    }

    public static <T> ApiRestResponse<T> success(T okData) {
        return new ApiRestResponse<>(OK_STATUS, OK_MSG, okData);
    }

    public static <T> ApiRestResponse<T> error(MallExceptionEnum ex) {
        return new ApiRestResponse<>(ex.getStatus(), ex.getMsg(), null);
    }

    public static <T> ApiRestResponse<T> error(Integer errorStatus, String errorMsg) {
        return new ApiRestResponse<>(errorStatus, errorMsg, null);
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
