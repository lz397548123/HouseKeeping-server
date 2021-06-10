package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.extend.OrderLineExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单项业务接口
 */

public interface OrderLineService {
    List<OrderLine> findAll();

    List<OrderLine> findByOrderId(Long id);

    void saveOrUpdate(OrderLine orderLine)throws CustomerException;

    void deleteById(long id) throws CustomerException;

    List<OrderLine> findByProductId(Long id);

    List<OrderLineExtend> findAllAboutProduct();
}
