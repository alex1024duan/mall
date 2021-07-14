package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.common.OrderBy;
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

    default Category selectOneByNameAndType(String name, Integer type) {
        QueryWrapper<Category> query = new QueryWrapper<>();
        query.eq("name", name);
        query.eq("type", type);
        return selectOne(query);
    }

    default Category selectOneByOrderNumAndType(Integer orderNum, Integer type) {
        QueryWrapper<Category> query = new QueryWrapper<>();
        query.eq("order_num", orderNum);
        query.eq("type", type);
        return selectOne(query);
    }

    default IPage<Category> selectPageOrderBy(Integer current, Integer size, OrderBy... orderBy) {
        IPage<Category> page = new Page<>(current, size);
        QueryWrapper<Category> query = new QueryWrapper<>();
        for(OrderBy o : orderBy) {
            query.orderBy(true, o.isAsc(), o.getField());
        }
        return selectPage(page, query);
    }

}
