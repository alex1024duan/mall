package org.djh.mall.exception;

import org.djh.mall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author alex1024duan
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ApiRestResponse<Object> handleException(Exception e) {
        log.error("System Exception : ", e);
        return ApiRestResponse.error(MallExceptionEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(MallException.class)
    public ApiRestResponse<Object> handleMallException(MallException e) {
        log.error("Mall Exception : ", e);
        return ApiRestResponse.error(e.getStatus(), e.getMsg());
    }

}
