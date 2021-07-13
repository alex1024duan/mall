package org.djh.mall.exception;

/**
 * @author alex1024duan
 */
public enum MallExceptionEnum {

    /**
     * 系统异常
     */
    SYSTEM_ERROR(20000, "系统异常"),

    /**
     * 用户名不能为空
     */
    NEED_USER_NAME(10001, "用户名不能为空"),

    /**
     * 密码不能为空
     */
    NEED_PASSWORD(10002, "密码不能为空"),

    /**
     * 用户名长度不能小于8位
     */
    USERNAME_TOO_SHORT(10003, "用户名长度不能小于8位"),

    /**
     * 密码长度不能小于8位
     */
    PASSWORD_TOO_SHORT(10004, "密码长度不能小于8位"),

    /**
     * 不允许重名, 注册失败
     */
    USERNAME_EXISTED(10005, "不允许重名, 注册失败"),

    /**
     * 插入失败, 请重试
     */
    INSERT_FAILED(10006, "插入失败, 请重试");

    private final Integer status;
    private final String msg;

    MallExceptionEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
