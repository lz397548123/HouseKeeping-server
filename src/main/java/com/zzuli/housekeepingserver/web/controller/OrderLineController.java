package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.OrderLine;
import com.zzuli.housekeepingserver.service.OrderLineService;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private OrderLineService orderLineService;

    @ApiOperation("查询所有订单列表信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", orderLineService.findAll());
    }

    @ApiOperation(value = "根据订单编号ID查询订单项")
    @GetMapping("/findByOrderId")
    public Message findByOrderId(Long id) {
        return MessageUtil.success("success", orderLineService.findByOrderId(id));
    }

    @ApiOperation(value = "保存或通过id更新订单列表信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody OrderLine orderLine) {
        orderLineService.saveOrUpdate(orderLine);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation("通过id删除订单列表信息")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        orderLineService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "根据产品编号ID查询订单项")
    @GetMapping("/findByProductId")
    public Message findByProductId(Long id) {
        return MessageUtil.success("success", orderLineService.findByProductId(id));
    }

    @ApiOperation("查出订单产品的详细信息")
    @GetMapping("/findAllAboutProduct")
    public Message findAllAboutProduct() {
        return MessageUtil.success("success", orderLineService.findAllAboutProduct());
    }
}
