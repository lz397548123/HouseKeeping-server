package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.OrderExample;
import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.extend.OrderExtend;
import com.zzuli.housekeepingserver.dao.OrderLineMapper;
import com.zzuli.housekeepingserver.dao.OrderMapper;
import com.zzuli.housekeepingserver.dao.extend.OrderExtendMapper;
import com.zzuli.housekeepingserver.service.OrderService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import com.zzuli.housekeepingserver.vm.OrderVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单业务接口实现类
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderLineMapper orderLineMapper;

    @Resource
    private OrderExtendMapper orderExtendMapper;

    @Override
    public void commit(OrderVM orderVM) throws CustomerException {
        /*
          1. 分别获取到订单信息 及 订单项信息
          2. 先保存订单信息
          3. 保存订单项信息
         */
        Order order = new Order();
        order.setTotal(orderVM.getTotal());
        order.setAddressId(orderVM.getAddressId());
        order.setCustomerId(orderVM.getCustomerId());
        order.setEmployeeId(orderVM.getEmployeeId());
        order.setOrderTime(new Date().getTime());
        order.setStatus(OrderExtend.STATUS_WFK);
        orderMapper.insert(order);

        List<OrderLine> orderLines = orderVM.getOrderLines();
        for (OrderLine orderLine : orderLines) {
            // 设置order与orderLine之间的关键（外键维护）
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }
    }

    @Override
    public List<Order> findAll() {
        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public OrderExtend findOrderDetailsById(Long id) {
        return orderExtendMapper.selectById(id);
    }
}
