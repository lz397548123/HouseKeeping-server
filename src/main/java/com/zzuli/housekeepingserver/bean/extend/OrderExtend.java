package com.zzuli.housekeepingserver.bean.extend;

import com.zzuli.housekeepingserver.bean.Address;
import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.bean.User;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单扩展类
 */

public class OrderExtend extends Order {
    public static final String STATUS_WFK = "未付款";
    public static final String STATUS_DPD = "待派单";
    public static final String STATUS_DFW = "待服务";
    public static final String STATUS_DQR = "待确认";
    public static final String STATUS_YWC = "已完成";

    private User customer;
    private User employee;
    private Address address;

    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
