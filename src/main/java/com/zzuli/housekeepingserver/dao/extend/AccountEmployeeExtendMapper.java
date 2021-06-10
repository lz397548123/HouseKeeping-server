package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.AccountEmployeeExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      员工账户扩展接口
 */

public interface AccountEmployeeExtendMapper {
    List<AccountEmployeeExtend> selectAllWithOrderAndUser();
}
