package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.service.OrderService;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import com.zzuli.housekeepingserver.vm.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private OrderService orderService;

    @ApiOperation("提交订单")
    @PostMapping("/commit")
    public Message commit(@RequestBody OrderVM orderVM) {
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }

    @GetMapping("/query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "订单状态", required = false, paramType = "query")
    })
    public Message query(String status) {
        return MessageUtil.success("success", orderService.query(status));
    }

    @ApiOperation("查询所有")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", orderService.findAll());
    }

    @ApiOperation(value = "根据id查询订单信息以及订单中的顾客、员工、地址、订单项信息）")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", orderService.findOrderDetailsById(id));
    }

    @ApiOperation("支付订单")
    @GetMapping("/payOrder")
    public Message payOrder(Long orderId) throws Exception {
        orderService.payOrder(orderId);
        return MessageUtil.success("success");
    }

    @ApiOperation("派单")
    @GetMapping("/sendOrder")
    public Message sendOrder(Long orderId, long employeeId) throws Exception {
        orderService.sendOrder(orderId, employeeId);
        return MessageUtil.success("success");
    }

    @ApiOperation("服务订单")
    @GetMapping("/rejectOrder")
    public Message rejectOrder(Long orderId) throws Exception {
        orderService.rejectOrder(orderId);
        return MessageUtil.success("success");
    }

    @ApiOperation("确认订单")
    @GetMapping("/confirmOrder")
    public Message confirmOrder(Long orderId) throws Exception {
        orderService.confirmOrder(orderId);
        return MessageUtil.success("success");
    }
}
