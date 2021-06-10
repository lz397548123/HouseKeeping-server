package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.OrderLineExample;
import com.zzuli.housekeepingserver.bean.extend.OrderLineExtend;
import com.zzuli.housekeepingserver.dao.OrderLineMapper;
import com.zzuli.housekeepingserver.dao.extend.OrderLineExtendMapper;
import com.zzuli.housekeepingserver.service.OrderLineService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单列表业务实现类
 */

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderLineExtendMapper orderLineExtendMapper;

    @Override
    public List<OrderLine> findAll() {
        return orderLineMapper.selectByExample(new OrderLineExample());
    }

    @Override
    public List<OrderLine> findByOrderId(Long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andOrderIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }

    @Override
    public void saveOrUpdate(OrderLine orderLine) throws CustomerException {
        if (orderLine.getId() == null) {
            orderLineMapper.updateByPrimaryKey(orderLine);
        } else {
            orderLineMapper.insert(orderLine);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        OrderLine orderLine = orderLineMapper.selectByPrimaryKey(id);
        //先判断该id对应的数据是否存在？
        if (orderLine != null) {
            //不存在，报错
            throw new CustomerException("删除失败，要删除的数据不存在");
        }
        orderLineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderLine> findByProductId(Long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andProductIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }

    @Override
    public List<OrderLineExtend> findAllAboutProduct() {
        return orderLineExtendMapper.selectAllAboutProduct();
    }
}
