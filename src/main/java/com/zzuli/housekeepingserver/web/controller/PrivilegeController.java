package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.service.PrivilegeService;
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
 * liang         2021/6/4       权限管理接口
 */

@RestController
@RequestMapping("/privilege")
@Api(description = "权限管理接口")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @ApiOperation(value = "查询全部权限信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("（查询所有）success", privilegeService.findAll());
    }

    @ApiOperation(value = "通过id查询权限信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", privilegeService.findById(id));
    }

    @ApiOperation(value = "保存或通过id更新权限信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Privilege privilege) {
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("保存或更新信息成功");
    }

    @ApiOperation(value = "通过id删除权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        privilegeService.deleteById(id);
        return MessageUtil.success("通过ID删除权限信息成功");
    }

    @ApiOperation(value = "查询权限树")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("（查询所有权限，并且级联所属子权限）success", privilegeService.findAllWithChild());
    }

    @ApiOperation(value = "查询权限，并且级联相关角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/findWithRoleById")
    public Message findWithRoleById(Long id) {
        return MessageUtil.success("（查询权限，并且级联相关角色）success", privilegeService.findWithRoleById(id));
    }

}
