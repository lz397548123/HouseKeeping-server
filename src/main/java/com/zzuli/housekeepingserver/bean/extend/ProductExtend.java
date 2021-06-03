package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.Product;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2      产品扩展类：在产品类的基础上扩展
 */

public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
