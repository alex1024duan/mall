package org.djh.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.djh.mall.entity.Category;

/**
 * <p>
 * 商品分类  服务类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
public interface ICategoryService extends IService<Category> {

    void adminCategoryAdd(Category category);

    void adminCategoryUpdate(Category category);

    void adminCategoryDelete(Integer id);

    IPage<Category> adminCategoryList(Integer pageNum, Integer pageSize);
}
