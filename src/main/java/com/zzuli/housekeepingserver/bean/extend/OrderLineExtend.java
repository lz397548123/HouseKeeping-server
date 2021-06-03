package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.Product;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单项的拓展类
 */

public class OrderLineExtend extends OrderLine {
    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
