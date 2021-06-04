package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.extend.OrderExtend;
import com.zzuli.housekeepingserver.service.impl.OrderServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import com.zzuli.housekeepingserver.vm.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       订单管理接口
 */

@RestController
@RequestMapping("/order")
@Api(description = "订单管理接口")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 提交订单
     * @param orderVM 订单视图
     * @return Message
     */
    @PostMapping("/commit")
    @ApiOperation(value = "commit（提交订单）")
    public Message commit(@RequestBody OrderVM orderVM) {
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", orderService.findAll());
    }

    @ApiOperation(value = "findById（根据id查询订单信息以及订单中的顾客、员工、地址、订单项信息）")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", orderService.findOrderDetailsById(id));
    }
}
