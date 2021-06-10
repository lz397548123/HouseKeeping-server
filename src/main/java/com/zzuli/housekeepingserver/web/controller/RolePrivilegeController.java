package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.RolePrivilege;
import com.zzuli.housekeepingserver.service.RolePrivilegeService;
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
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      角色权限控制器
 */

@RestController
@RequestMapping("/rolePrivilege")
@Api(description = "角色权限管理接口")
public class RolePrivilegeController {
    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    @ApiOperation(value = "查询所有角色权限")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", rolePrivilegeService.findAll());
    }

    @ApiOperation(value = "通过id查询角色权限")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", rolePrivilegeService.findById(id));
    }

    @ApiOperation(value = "保存或通过id更新角色权限")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody RolePrivilege rolePrivilege) {
        rolePrivilegeService.saveOrUpdate(rolePrivilege);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过id删除角色权限")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        rolePrivilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "查询角色权限+角色+权限信息")
    @GetMapping("/findAllWithRoleAndPrivilege")
    public Message findAllWithRoleAndPrivilege() {
        return MessageUtil.success("success", rolePrivilegeService.findAllWithRoleAndPrivilege());
    }
}
