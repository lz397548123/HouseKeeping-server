package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Role;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       角色扩展类
 */

public class RoleExtend extends Role {
    List<PrivilegeExtend> privileges;

    public List<PrivilegeExtend> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeExtend> privileges) {
        this.privileges = privileges;
    }
}
