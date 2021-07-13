package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.OrderItem;

/**
 * <p>
 * 订单的商品表  Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}
