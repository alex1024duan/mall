package org.djh.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.djh.mall.common.Constant;
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
    public void register(String userName, String password) {
        if(userMapper.selectOneByUsername(userName) != null) {
            throw new MallException(MallExceptionEnum.USER_EXISTED);
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(Md5Utils.getMd5Str(password));
        if(userMapper.insert(user) == 0) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public User login(String userName, String password) {
        User user = userMapper.selectOneByUsername(userName);

        if(user == null) {
            throw new MallException(MallExceptionEnum.USER_NO_EXISTED);
        }

        if(!Md5Utils.getMd5Str(password).equals(user.getPassword())) {
            throw new MallException(MallExceptionEnum.PASSWORD_CHECK_FAILED);
        }

        user.setPassword(null);
        return user;
    }

    @Override
    public void userUpdate(String signature, Integer id) {
        User user = new User();
        user.setId(id);
        user.setPersonalizedSignature(signature);
        if(userMapper.updateById(user) == 0) {
            throw new MallException(MallExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public User adminLogin(String userName, String password) {
        User user = login(userName, password);

        if(!Constant.ADMIN_ROLE_VALUE.equals(user.getRole())) {
            throw new MallException(MallExceptionEnum.IS_NOT_ADMIN);
        }

        return user;
    }

}
