package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.service.AccountEmployeeService;
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
 * liang         2021/6/4       员工账户管理接口
 */

@RestController
@RequestMapping("/accountEmployee")
@Api(description = "员工控制器")
public class AccountEmployeeController {
    @Autowired
    private AccountEmployeeService accountEmployeeService;

    @ApiOperation(value = "查询所有员工信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", accountEmployeeService.findAll());
    }

    @ApiOperation(value = "通过id查询员工信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", accountEmployeeService.findById(id));
    }

    @ApiOperation(value = "保存或通过id更新员工信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountEmployee accountEmployee) {
        accountEmployeeService.saveOrUpdate(accountEmployee);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除员工信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        accountEmployeeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "查询员工+订单+用户信息")
    @GetMapping("/findAllWithOrderAndUser")
    public Message findAllWithOrderAndUser() {
        return MessageUtil.success("success", accountEmployeeService.findAllWithOrderAndUser());
    }
}
