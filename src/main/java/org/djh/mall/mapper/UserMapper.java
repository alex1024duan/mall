package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表  Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
