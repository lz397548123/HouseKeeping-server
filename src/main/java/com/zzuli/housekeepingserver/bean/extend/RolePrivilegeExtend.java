package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.bean.Role;
import com.zzuli.housekeepingserver.bean.RolePrivilege;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      角色权限类
 */

public class RolePrivilegeExtend extends RolePrivilege {
    private Role role;
    private Privilege privilege;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
