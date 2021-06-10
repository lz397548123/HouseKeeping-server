package com.zzuli.housekeepingserver.dao.extend;

import com.zzuli.housekeepingserver.bean.extend.RolePrivilegeExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      角色权限接口
 */

public interface RolePrivilegeExtendMapper {
    List<RolePrivilegeExtend> selectAllWithRoleAndPrivilege();
}
