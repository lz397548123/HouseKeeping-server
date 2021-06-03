package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Role;
import com.zzuli.housekeepingserver.bean.User;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       用户拓展类
 */

public class UserExtend extends User {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
