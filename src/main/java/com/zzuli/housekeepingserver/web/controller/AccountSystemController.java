package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.AccountSystem;
import com.zzuli.housekeepingserver.service.AccountSystemService;
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
 * liang         2021/6/4       系统账户管理接口
 */

@RestController
@RequestMapping("/accountSystem")
@Api(description = "系统账户管理接口")
public class AccountSystemController {
    @Autowired
    private AccountSystemService accountSystemService;

    @ApiOperation(value = "findAll（查询所有系统账户）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", accountSystemService.findAll());
    }

    @ApiOperation(value = "通过id查询系统账户信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", accountSystemService.findById(id));
    }

    @ApiOperation(value = "保存或通过id更新系统账户信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountSystem accountSystem) {
        accountSystemService.saveOrUpdate(accountSystem);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除系统账户信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        accountSystemService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "查询系统账户+订单+用户信息")
    @GetMapping("findAllWithOrderAndUser")
    public Message findAllWithOrderAndUser() {
        return MessageUtil.success("success", accountSystemService.findAllWithOrderAndUser());
    }

}
