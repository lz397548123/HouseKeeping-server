package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.AccountCustomer;
import com.zzuli.housekeepingserver.service.AccountCustomerService;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       用户账户管理接口
 */

@RestController
@RequestMapping("/accountCustomer")
@Api(description = "顾客控制器")
public class AccountCustomerController {
    @Autowired
    private AccountCustomerService accountCustomerService;

    @ApiOperation(value = "查询所有客户信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", accountCustomerService.findAll());
    }

    @ApiOperation(value = "通过id查询客户信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", accountCustomerService.findById(id));
    }

    @ApiOperation(value = "保存或通过id更新客户信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountCustomer accountCustomer) {
        accountCustomerService.saveOrUpdate(accountCustomer);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除客户信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        accountCustomerService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "查询客户+订单+用户信息")
    @GetMapping("findAllWithOrderAndUser")
    public Message findAllWithOrderAndUser() {
        return MessageUtil.success("success", accountCustomerService.findAllWithOrderAndUser());
    }

}
