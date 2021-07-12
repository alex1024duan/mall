package org.djh.mall.controller;

import org.djh.mall.model.pojo.User;
import org.djh.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alex1024duan
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public User personalPage() {
        return userService.getUser();
    }

}
