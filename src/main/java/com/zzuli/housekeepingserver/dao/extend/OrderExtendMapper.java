package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.OrderExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单扩展接口
 */

public interface OrderExtendMapper {
    OrderExtend selectById(Long id);

    // 多条件符合查询
    List<OrderExtend> query(Long id, String status);
}
