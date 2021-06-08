package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Role;
import com.zzuli.housekeepingserver.service.impl.RoleServiceImpl;
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
 * liang         2021/6/4       角色管理接口
 */

@RestController
@RequestMapping("/role")
@Api(description = "角色管理接口")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @ApiOperation(value = "findAll（查询所有角色带权限）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", roleService.findAll());
    }

    /**
     * 查询角色带权限
     *
     * @param id 编号
     * @return Message
     */
    @ApiOperation(value = "findWithPrivilegeById（通过ID查找角色信息带权限）")
    @PostMapping("/findWithPrivilegeById")
    public Message findWithPrivilegeById(Long id) {
        return MessageUtil.success("success", roleService.findWithPrivilegeById(id));
    }

    @ApiOperation(value = "deleteById（通过ID删除角色信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新角色信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Role role) {
        roleService.saveOrUpdate(role);
        return MessageUtil.success("保存或更新成功");
    }
}
