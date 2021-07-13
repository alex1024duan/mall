package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.Category;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    default Category selectOneByName(String name) {
        QueryWrapper<Category> query = new QueryWrapper<>();
        query.eq("name", name);
        return selectOne(query);
    }

}
