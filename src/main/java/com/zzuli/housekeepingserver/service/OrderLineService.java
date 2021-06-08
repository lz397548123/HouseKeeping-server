package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.OrderLine;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单项业务接口
 */

public interface OrderLineService {
    List<OrderLine> findByOrderId(Long id);

    List<OrderLine> findByProductId(Long id);
}
