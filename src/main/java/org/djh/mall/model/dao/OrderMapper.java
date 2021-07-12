package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.model.pojo.Order;

/**
 * @author alex1024duan
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}