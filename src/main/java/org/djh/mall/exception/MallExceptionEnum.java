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
     * 用户已存在
     */
    USER_EXISTED(10001, "用户已存在"),

    /**
     * 用户不存在
     */
    USER_NO_EXISTED(10002, "用户不存在"),

    /**
     * 密码错误
     */
    PASSWORD_CHECK_FAILED(10003, "密码错误"),

    /**
     * 执行此操作前需要先进行登录
     */
    NEED_LOGIN(10004, "执行此操作前需要先进行登录"),

    /**
     * 插入失败, 请重试
     */
    INSERT_FAILED(10005, "插入失败, 请重试"),

    /**
     * 更新失败, 请重试
     */
    UPDATE_FAILED(10006, "更新失败, 请重试"),

    /**
     * 您不是管理员, 没有相关权限
     */
    IS_NOT_ADMIN(10007, "您不是管理员, 没有相关权限"),

    /**
     * 请求参数错误
     */
    REQUEST_PARAM_ERROR(10008, "请求参数错误"),

    /**
     * 同层级下目录已存在
     */
    CATEGORY_EXISTED(10009, "同层级下目录已存在");

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
