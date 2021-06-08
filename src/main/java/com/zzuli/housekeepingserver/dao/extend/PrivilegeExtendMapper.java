package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.PrivilegeExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       权限接口的扩展类
 */

public interface PrivilegeExtendMapper {
    List<PrivilegeExtend> selectAllWithChild();

    List<PrivilegeExtend> selectWithRoleById(Long id);
}
