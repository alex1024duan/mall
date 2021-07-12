package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.djh.mall.model.pojo.User;

/**
 * @author alex1024duan
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    @Select(value = "select * from mall_user where id = #{id}")
    User selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}