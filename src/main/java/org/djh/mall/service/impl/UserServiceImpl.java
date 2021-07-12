package org.djh.mall.service.impl;

import org.djh.mall.model.dao.UserMapper;
import org.djh.mall.model.pojo.User;
import org.djh.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alex1024duan
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

}
