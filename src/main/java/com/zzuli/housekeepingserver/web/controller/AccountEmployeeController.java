package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.service.impl.AccountEmployeeServiceImpl;
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
 * liang         2021/6/4       员工账户管理接口
 */

@RestController
@RequestMapping("/accountEmployee")
@Api(description = "员工账户管理接口")
public class AccountEmployeeController {
    @Autowired
    private AccountEmployeeServiceImpl accountEmployeeService;

    @ApiOperation(value = "findAll（查询所有员工账户）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", accountEmployeeService.findAll());
    }

    @ApiOperation(value = "deleteById（通过ID删除员工账户的信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        accountEmployeeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountEmployee accountEmployee) {
        accountEmployeeService.saveOrUpdate(accountEmployee);
        return MessageUtil.success("保存或更新成功");
    }
}
