package com.zzuli.housekeepingserver.vm;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.OrderLine;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单视图类
 */

public class OrderVM extends Order {
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
