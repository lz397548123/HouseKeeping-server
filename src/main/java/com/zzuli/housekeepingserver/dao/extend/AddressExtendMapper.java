package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.AddressExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      地址扩展接口
 */

public interface AddressExtendMapper {
    List<AddressExtend> selectAllWithUser();
}
