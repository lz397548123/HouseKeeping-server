package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.AccountSystemExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      系统账户接口
 */

public interface AccountSystemExtendMapper {
    List<AccountSystemExtend> selectAllWithOrderAndUser();
}
