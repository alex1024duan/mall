package org.djh.mall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.djh.mall.common.OrderBy;
import org.djh.mall.entity.Category;
import org.djh.mall.exception.MallException;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.mapper.CategoryMapper;
import org.djh.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类  服务实现类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void adminCategoryAdd(Category category) {
        Category oldCategory = categoryMapper.selectOneByNameAndType(category.getName(), category.getType());
        if(oldCategory != null) {
            throw new MallException(MallExceptionEnum.CATEGORY_NAME_EXISTED);
        }

        oldCategory = categoryMapper.selectOneByOrderNumAndType(category.getOrderNum(), category.getType());
        if(oldCategory != null) {
            throw new MallException(MallExceptionEnum.CATEGORY_ORDER_NUM_EXISTED);
        }

        if(categoryMapper.insert(category) == 0) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public void adminCategoryUpdate(Category category) {
        Category oldCategory = categoryMapper.selectById(category.getId());
        if(oldCategory == null) {
            throw new MallException(MallExceptionEnum.CATEGORY_NO_EXISTED);
        }

        oldCategory = categoryMapper.selectOneByNameAndType(category.getName(), category.getType());
        if(oldCategory != null && !oldCategory.getId().equals(category.getId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_NAME_EXISTED);
        }

        oldCategory = categoryMapper.selectOneByOrderNumAndType(category.getOrderNum(), category.getType());
        if(oldCategory != null && !oldCategory.getId().equals(category.getId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ORDER_NUM_EXISTED);
        }

        if(categoryMapper.updateById(category) == 0) {
            throw new MallException(MallExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public void adminCategoryDelete(Integer id) {
        if(categoryMapper.selectById(id) == null) {
            throw new MallException(MallExceptionEnum.CATEGORY_NO_EXISTED);
        }

        if(categoryMapper.deleteById(id) == 0) {
            throw new MallException(MallExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public IPage<Category> adminCategoryList(Integer pageNum, Integer pageSize) {
        return categoryMapper.selectPageOrderBy(pageNum, pageSize, new OrderBy("type", true), new OrderBy("order_num", true));
    }

}
