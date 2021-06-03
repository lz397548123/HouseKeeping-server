package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.ProductExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2      产品扩展接口：在基础接口之外扩展
 */

public interface ProductExtendMapper {
    List<ProductExtend> selectAllWithCategory();

}
