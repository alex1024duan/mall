package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.User;

/**
 * <p>
 * 用户表  Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    default User selectOneByUsername(String username) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", username);
        return selectOne(query);
    }

}
