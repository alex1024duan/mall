package org.djh.mall.exception;

import org.djh.mall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiRestResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException : ", e);
        return handleBindingResult(e.getBindingResult());
    }

    private ApiRestResponse<Object> handleBindingResult(BindingResult result) {
        List<String> list = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String message = objectError.getDefaultMessage();
                list.add(message);
            }
        }
        if (list.size() == 0) {
            return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), list.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ApiRestResponse<Object> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ConstraintViolationException : ", e);
        return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), e.getMessage());
    }

}
