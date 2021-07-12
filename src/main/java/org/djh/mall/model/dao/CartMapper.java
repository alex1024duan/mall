package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.model.pojo.Cart;

/**
 * @author alex1024duan
 */
@Mapper
public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}