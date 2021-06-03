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
    void commit(OrderVM orderVM) throws CustomerException;

    List<Order> findAll();

    OrderExtend findOrderDetailsById(Long id);
}
