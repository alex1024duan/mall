package org.djh.mall.controller;

import org.djh.mall.common.ApiRestResponse;
import org.djh.mall.common.Constant;
import org.djh.mall.entity.User;
import org.djh.mall.exception.MallException;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@RestController
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ApiRestResponse<User> register(@RequestParam String userName, @RequestParam String password) throws MallException {
        if("".equals(userName.trim())) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_USER_NAME);
        }
        if("".equals(password.trim())) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_PASSWORD);
        }

        if(userName.length() < Constant.USERNAME_MIN_LENGTH) {
            return ApiRestResponse.error(MallExceptionEnum.USERNAME_TOO_SHORT);
        }
        if(password.length() < Constant.PASSWORD_MIN_LENGTH) {
            return ApiRestResponse.error(MallExceptionEnum.PASSWORD_TOO_SHORT);
        }

        userService.register(userName, password);

        return ApiRestResponse.success();
    }

}
