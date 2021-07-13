package org.djh.mall.service.impl;

import org.djh.mall.entity.Order;
import org.djh.mall.mapper.OrderMapper;
import org.djh.mall.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表; 服务实现类
 * </p>
 *
 * @author alex1024duan
 * @since 2021-07-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
