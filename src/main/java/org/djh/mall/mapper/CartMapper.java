package org.djh.mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
@Repository
public interface CartMapper extends BaseMapper<Cart> {

}
