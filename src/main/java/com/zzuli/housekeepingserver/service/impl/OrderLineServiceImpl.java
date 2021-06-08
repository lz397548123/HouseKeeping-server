package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.OrderLineExample;
import com.zzuli.housekeepingserver.dao.OrderLineMapper;
import com.zzuli.housekeepingserver.service.OrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单项业务实现类
 */

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Resource
    private OrderLineMapper orderLineMapper;

    @Override
    public List<OrderLine> findByOrderId(Long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andOrderIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }

    @Override
    public List<OrderLine> findByProductId(Long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andProductIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }
}
