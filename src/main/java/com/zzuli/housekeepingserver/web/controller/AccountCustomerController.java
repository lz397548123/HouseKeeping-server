package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.AccountCustomer;
import com.zzuli.housekeepingserver.service.impl.AccountCustomerServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
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
 * liang         2021/6/4       用户账户管理接口
 */

@RestController
@RequestMapping("/accountCustomer")
@Api(description = "顾客账户管理接口")
public class AccountCustomerController {
    @Autowired
    private AccountCustomerServiceImpl accountCustomerService;

    @ApiOperation(value = "findAll（查询所有用户账户）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", accountCustomerService.findAll());
    }

    @ApiOperation(value = "deleteById（通过ID删除用户账户的信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        accountCustomerService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountCustomer accountCustomer) {
        accountCustomerService.saveOrUpdate(accountCustomer);
        return MessageUtil.success("保存或更新成功");
    }
}
