package org.djh.mall.exception;

/**
 * @author alex1024duan
 */
public class MallException extends Exception {

    private final Integer status;
    private final String msg;

    public MallException(MallExceptionEnum ex) {
        this.status = ex.getStatus();
        this.msg = ex.getMsg();
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
