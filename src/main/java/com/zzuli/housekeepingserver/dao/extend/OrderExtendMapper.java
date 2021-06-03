package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.OrderExtend;


/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单扩展接口
 */

public interface OrderExtendMapper {
    OrderExtend selectById(Long id);
}
