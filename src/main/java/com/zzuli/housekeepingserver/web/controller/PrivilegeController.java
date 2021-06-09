package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.service.impl.PrivilegeServiceImpl;
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
    private PrivilegeServiceImpl privilegeService;

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("（查询所有）success", privilegeService.findAll());
    }

    /**
     * 查询所有权限，并且级联所属子权限
     *
     * @return Message
     */
    @ApiOperation(value = "findAllWithChild（查询所有权限，并且级联所属子权限）")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("（查询所有权限，并且级联所属子权限）success", privilegeService.findAllWithChild());
    }

    /**
     * 查询权限，并且级联相关角色
     *
     * @return Message
     */
    @ApiOperation(value = "findWithRoleById（查询权限，并且级联相关角色）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/findWithRoleById")
    public Message findWithRoleById(Long id) {
        return MessageUtil.success("（查询权限，并且级联相关角色）success", privilegeService.findWithRoleById(id));
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Privilege privilege) {
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("保存或更新信息或更新成功");
    }

    @ApiOperation(value = "deleteById（通过ID删除权限信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        privilegeService.deleteById(id);
        return MessageUtil.success("通过ID删除权限信息成功");
    }
}
