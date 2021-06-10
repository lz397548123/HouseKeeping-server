package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.extend.OrderExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;
import com.zzuli.housekeepingserver.vm.OrderVM;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单业务接口
 */

public interface OrderService {
    /**
     * 新建订单
     *
     * @param orderVM
     * @throws CustomerException
     */
    void commit(OrderVM orderVM) throws CustomerException;

    /**
     * 查询全部订单
     *
     * @return
     */
    List<Order> findAll();

    /**
     * 根据状态查询订单
     *
     * @param status
     * @return
     */
    List<OrderExtend> query(String status);

    /**
     * 根据订单id查询订单详情（顾客/地址/订单项等内容）
     *
     * @param id
     * @return
     */
    OrderExtend findOrderDetailsById(Long id);

    /**
     * 支付订单（进入待派单状态）
     *
     * @param orderId
     */
    void payOrder(Long orderId) throws Exception;

    /**
     * 派单（进入待接单状态->进入待服务状态）
     *
     * @param orderId
     * @param employeeId
     */
    void sendOrder(Long orderId, Long employeeId) throws Exception;

    /**
     * 接单（进入待服务状态）
     * @param orderId
     */
//    void takeOrder(long orderId) throws Exception;

    /**
     * 服务结束（进入待确认状态）
     *
     * @param orderId
     */
    void rejectOrder(Long orderId) throws Exception;

    /**
     * 确认订单（进入已完成状态）
     *
     * @param orderId
     */
    void confirmOrder(Long orderId) throws Exception;
}
