package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.service.impl.OrderLineServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       订单项管理接口
 */

@RestController
@RequestMapping("/orderLine")
@Api(description = "订单项管理接口")
public class OrderLineController {
    @Autowired
    private OrderLineServiceImpl orderLineService;

    @ApiOperation(value = "根据订单编号ID查询订单项")
    @PostMapping("/findByOrderId")
    public Message findByOrderId(Long id) {
        return MessageUtil.success("success", orderLineService.findByOrderId(id));
    }

    @ApiOperation(value = "根据产品编号ID查询订单项")
    @PostMapping("/findByProductId")
    public Message findByProductId(Long id) {
        return MessageUtil.success("success", orderLineService.findByProductId(id));
    }
}
