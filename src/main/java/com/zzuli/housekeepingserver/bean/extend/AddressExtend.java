package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Address;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      地址扩展类
 */

public class AddressExtend extends Address {
    List<Address> children;

    public List<Address> getChildren() {
        return children;
    }

    public void setChildren(List<Address> children) {
        this.children = children;
    }
}
