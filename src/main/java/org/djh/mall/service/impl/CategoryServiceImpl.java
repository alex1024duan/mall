package org.djh.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.djh.mall.entity.Category;
import org.djh.mall.exception.MallException;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.mapper.CategoryMapper;
import org.djh.mall.request.AdminCategoryAddRequest;
import org.djh.mall.service.ICategoryService;
import org.springframework.beans.BeanUtils;
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
    public void adminCategoryAdd(AdminCategoryAddRequest request) {
        Category category = new Category();
        BeanUtils.copyProperties(request, category);

        Category oldCategory = categoryMapper.selectOneByName(category.getName());
        if(oldCategory != null && oldCategory.getType().equals(category.getType())) {
            throw new MallException(MallExceptionEnum.CATEGORY_EXISTED);
        }

        if(categoryMapper.insert(category) == 0) {
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

}
