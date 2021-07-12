package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.model.pojo.OrderItem;

/**
 * @author alex1024duan
 */
@Mapper
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}