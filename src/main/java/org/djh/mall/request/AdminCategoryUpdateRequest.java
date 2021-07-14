package org.djh.mall.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author alex1024duan
 */
public class AdminCategoryUpdateRequest {

    /**
     * 参数含义: 目录的id
     * 示例: 4
     * 备注:
     */
    @NotNull(message = "目录id不能为空")
    @Min(value = 0, message = "目录id最小只能为0")
    private Integer id;

    /**
     * 参数含义: 目录名
     * 示例: 新鲜水果
     * 备注:
     */
    @Pattern(message = "目录名不能为空", regexp = "^.*\\S+.*$")
    @Length(min = 2, max = 5, message = "目录名长度必须满足2到5个字符")
    private String name;

    /**
     * 参数含义: 目录层级
     * 示例: 1
     * 备注: 不超过3级
     */
    @Max(value = 3, message = "目录层级不能超过3级")
    @Min(value = 1, message = "目录层级不能低于1级")
    private Integer type;

    /**
     * 参数含义: 父目录的ID
     * 示例: 2
     * 备注: 1级目录的parentId为0
     */
    @Min(value = 0, message = "父目录ID最小只能为0")
    private Integer parentId;

    /**
     * 参数含义: 排序位次
     * 示例: 5
     * 备注: 同级目录的排序位次
     */
    private Integer orderNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "AdminCategoryUpdate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                '}';
    }

}
