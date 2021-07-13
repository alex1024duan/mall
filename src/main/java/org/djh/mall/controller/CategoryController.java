package org.djh.mall.controller;

import io.swagger.annotations.ApiOperation;
import org.djh.mall.common.ApiRestResponse;
import org.djh.mall.common.Constant;
import org.djh.mall.entity.Category;
import org.djh.mall.entity.User;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.request.AdminCategoryAddRequest;
import org.djh.mall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * <p>
 * 商品分类  前端控制器
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@RestController
public class CategoryController {

    private ICategoryService categoryService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/admin/category/add")
    @ApiOperation(value = "增加目录分类")
    public ApiRestResponse<Category> adminCategoryAdd
            (@RequestBody @Valid AdminCategoryAddRequest request,
             HttpSession session)
    {
        User currentUser = (User)session.getAttribute(Constant.MALL_USER);
        if(currentUser == null) {
            return ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN);
        }
        if(!Constant.ADMIN_ROLE_VALUE.equals(currentUser.getRole())) {
            return ApiRestResponse.error(MallExceptionEnum.IS_NOT_ADMIN);
        }

        categoryService.adminCategoryAdd(request);

        return ApiRestResponse.success(null);
    }

}
