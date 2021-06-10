package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.OrderExample;
import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.extend.OrderExtend;
import com.zzuli.housekeepingserver.dao.OrderLineMapper;
import com.zzuli.housekeepingserver.dao.OrderMapper;
import com.zzuli.housekeepingserver.dao.UserMapper;
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
 * liang         2021/6/3       订单业务实现类
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Resource
    private OrderLineMapper orderLineMapper;

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

        List<OrderLine> orderLines = orderVM.getOrderLines();

        orderMapper.insert(order);

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

    /**
     * 根据状态查询订单
     *
     * @param status
     * @return
     */
    @Override
    public List<OrderExtend> query(String status) {
        return orderExtendMapper.query(null, status);
    }

    @Override
    public OrderExtend findOrderDetailsById(Long id) {
        List<OrderExtend> list = orderExtendMapper.query(id, null);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 支付订单（进入待派单状态）
     *
     * @param orderId
     */
    @Override
    public void payOrder(Long orderId) throws Exception {
        // 支付订单
        // 省略支付流程...
        // 简化的支付流程
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new Exception("该订单不存在");
        }
        // 进入待派单状态
        order.setStatus(OrderExtend.STATUS_DPD);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 派单（进入待接单状态->进入待服务状态）
     *
     * @param orderId
     * @param employeeId
     */
    @Override
    public void sendOrder(Long orderId, Long employeeId) throws Exception {
        // 派单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new Exception("该订单不存在");
        } else if (!order.getStatus().equals("待派单")) {
            throw new Exception("订单未支付/订单异常");
        }
        User emp = userMapper.selectByPrimaryKey(employeeId);
        if (emp == null) {
            throw new Exception("该员工不存在");
        }
        // 进入待接单状态（省略）->进入待服务状
        order.setStatus(OrderExtend.STATUS_DFW);
        orderMapper.updateByPrimaryKey(order);
    }

//    @Override
//    public void takeOrder(long orderId) throws Exception {
//
//    }

    /**
     * 服务结束（进入待确认状态）
     *
     * @param orderId
     */
    @Override
    public void rejectOrder(Long orderId) throws Exception {
        //服务结束
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new Exception("该订单不存在");
        } else if (!order.getStatus().equals("待服务")) {
            throw new Exception("订单异常");
        }
        // 进入待确认状态
        order.setStatus(OrderExtend.STATUS_DQR);
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 确认订单（进入已完成状态）
     *
     * @param orderId
     */
    @Override
    public void confirmOrder(Long orderId) throws Exception {
        // 顾客确认订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new Exception("该订单不存在");
        } else if (!order.getStatus().equals("待确认")) {
            throw new Exception("订单异常");
        }
        // 进入已完成状态
        order.setStatus(OrderExtend.STATUS_YWC);
        orderMapper.updateByPrimaryKey(order);
    }
}
