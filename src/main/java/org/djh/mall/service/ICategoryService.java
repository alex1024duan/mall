package org.djh.mall.service;

import org.djh.mall.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.djh.mall.request.AdminCategoryAddRequest;

/**
 * <p>
 * 商品分类  服务类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
public interface ICategoryService extends IService<Category> {

    void adminCategoryAdd(AdminCategoryAddRequest request);
}
