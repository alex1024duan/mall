package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.Cart;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

}
