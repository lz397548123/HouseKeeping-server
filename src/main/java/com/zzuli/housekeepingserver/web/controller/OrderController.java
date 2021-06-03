package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Order;
import com.zzuli.housekeepingserver.bean.extend.OrderExtend;
import com.zzuli.housekeepingserver.service.impl.OrderServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import com.zzuli.housekeepingserver.vm.OrderVM;
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
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

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

    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", orderService.findOrderDetailsById(id));
    }
}