package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.model.pojo.Product;

/**
 * @author alex1024duan
 */
@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}