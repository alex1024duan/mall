package org.djh.mall.controller;

import io.swagger.annotations.ApiOperation;
import org.djh.mall.common.ApiRestResponse;
import org.djh.mall.common.Constant;
import org.djh.mall.entity.User;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.service.IUserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@RestController
@Validated
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "注册新用户")
    public ApiRestResponse<User> register
            (@NotBlank(message = "用户名不能为空") String userName,
             @NotBlank(message = "密码不能为空") @Length(message = "密码长度最少为8位", min = 8) String password)
    {
        userService.register(userName, password);
        return ApiRestResponse.success(null);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ApiRestResponse<User> login
            (@NotBlank(message = "用户名不能为空") String userName,
             @NotBlank(message = "密码不能为空") String password,
             HttpSession session)
    {
        User user = userService.login(userName, password);
        session.setAttribute(Constant.MALL_USER, user);
        return ApiRestResponse.success(user);
    }

    @PostMapping(value = "/user/update")
    @ApiOperation(value = "更新个性签名")
    public ApiRestResponse<User> userUpdate
            (@NotBlank(message = "个性签名不能为空") String signature,
             HttpSession session)
    {
        User sessionUser = (User)session.getAttribute(Constant.MALL_USER);
        if(sessionUser == null) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }

        userService.userUpdate(signature, sessionUser.getId());
        return ApiRestResponse.success(null);
    }

    @PostMapping(value = "/user/logout")
    @ApiOperation(value = "退出登录")
    public ApiRestResponse<User> userLogout(HttpSession session) {

        session.removeAttribute(Constant.MALL_USER);
        return ApiRestResponse.success(null);
    }

    @PostMapping(value = "/adminLogin")
    @ApiOperation(value = "管理员登录")
    public ApiRestResponse<User> adminLogin
            (@NotBlank(message = "用户名不能为空") String userName,
             @NotBlank(message = "密码不能为空") String password,
             HttpSession session)
    {
        User user = userService.adminLogin(userName, password);
        session.setAttribute(Constant.MALL_USER, user);
        return ApiRestResponse.success(user);
    }

}
