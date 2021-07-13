package org.djh.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.djh.mall.entity.User;
import org.djh.mall.exception.MallException;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.mapper.UserMapper;
import org.djh.mall.service.IUserService;
import org.djh.mall.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void register(String userName, String password) throws MallException {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", userName);
        userMapper.selectOne(query);
        if(getOne(query) != null) {
            throw new MallException(MallExceptionEnum.USERNAME_EXISTED);
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(Md5Utils.getMd5Str(password));
        if(userMapper.insert(user) != 1) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

}
