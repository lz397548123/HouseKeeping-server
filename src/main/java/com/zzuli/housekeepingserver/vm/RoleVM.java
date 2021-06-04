package com.zzuli.housekeepingserver.vm;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.bean.Role;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       角色视图
 */

public class RoleVM extends Order {
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
