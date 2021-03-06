package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Privilege;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       权限的扩展类
 */

public class PrivilegeExtend extends Privilege {
    public static final String TYPE_MANAGE = "管理";
    public static final String TYPE_BROWSE = "浏览";
    public static final String TYPE_GN = "功能";
    public static final String NAME_ZSGC = "增删改查";
    public static final String NAME_LOOK = "访问";
    public static final String NAME_LOGIN = "登录";
    public static final String NAME_PAY = "支付";
    public static final String NAME_COMMENT = "评论";

    List<Privilege> children;

    List<RoleExtend> roles;

    public List<RoleExtend> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleExtend> roles) {
        this.roles = roles;
    }

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }
}
