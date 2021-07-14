package org.djh.mall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.djh.mall.common.ApiRestResponse;
import org.djh.mall.entity.Category;
import org.djh.mall.exception.MallExceptionEnum;
import org.djh.mall.request.AdminCategoryAddRequest;
import org.djh.mall.request.AdminCategoryUpdateRequest;
import org.djh.mall.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 商品分类  前端控制器
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@RestController
@Validated
public class CategoryController {

    private ICategoryService categoryService;

    @Autowired
    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/admin/category/add")
    @ApiOperation(value = "增加目录分类")
    public ApiRestResponse<Category> adminCategoryAdd(@RequestBody @Valid AdminCategoryAddRequest request) {
        if(request.getType() == 1 && request.getParentId() != 0) {
            return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), "1级目录的parentId必须为0");
        }
        if(request.getType() != 1 && request.getParentId() == 0) {
            return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), "只有1级目录的parentId才能是0");
        }

        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        categoryService.adminCategoryAdd(category);
        return ApiRestResponse.success(null);
    }

    @PostMapping(value = "/admin/category/update")
    @ApiOperation(value = "更新目录分类")
    public ApiRestResponse<Category> adminCategoryUpdate(@RequestBody @Valid AdminCategoryUpdateRequest request) {
        if(request.getType() == 1 && request.getParentId() != 0) {
            return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), "1级目录的parentId必须为0");
        }
        if(request.getType() != 1 && request.getParentId() == 0) {
            return ApiRestResponse.error(MallExceptionEnum.REQUEST_PARAM_ERROR.getStatus(), "只有1级目录的parentId才能是0");
        }

        Category category = new Category();
        BeanUtils.copyProperties(request, category);
        categoryService.adminCategoryUpdate(category);
        return ApiRestResponse.success(null);
    }

    @PostMapping(value = "/admin/category/delete")
    @ApiOperation(value = "删除分类")
    public ApiRestResponse<Category> adminCategoryDelete
            (@NotNull(message = "目录id不能为空") @Min(value = 0, message = "目录id最小只能为0") Integer id)
    {
        categoryService.adminCategoryDelete(id);
        return ApiRestResponse.success(null);
    }

    @GetMapping(value = "/admin/category/list")
    @ApiOperation(value = "分类列表（平铺）")
    public ApiRestResponse<IPage<Category>> adminCategoryList
            (@Min(value = 1, message = "页码最小只能为1") @NotNull(message = "页码不能为空") Integer pageNum,
             @Min(value = 1, message = "每页至少需要包含一条数据") @Max(value = 500, message = "每页最多有500条数据") @NotNull(message = "必须提供每页需要包含的数据条数") Integer pageSize)
    {
        IPage<Category> page = categoryService.adminCategoryList(pageNum, pageSize);
        return ApiRestResponse.success(page);
    }

}
