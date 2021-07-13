package org.djh.mall.service;

import org.djh.mall.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.djh.mall.exception.MallException;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
public interface IUserService extends IService<User> {

    void register(String userName, String password) throws MallException;

}
