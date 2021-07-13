package org.djh.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.djh.mall.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表; Mapper 接口
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
