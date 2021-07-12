package org.djh.mall.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.model.pojo.Category;

/**
 * @author alex1024duan
 */
@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}