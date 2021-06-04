package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;
import com.zzuli.housekeepingserver.service.impl.UserServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       用户控制器
 */

@RestController
@RequestMapping("/user")
@Api(description = "用户管理接口")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询所有用户，并且级联获得用户角色
     * @return Message
     */
    @ApiOperation(value = "findAllWithRole（查询所有用户，并且级联获得用户角色）")
    @GetMapping("/findAllWithRole")
    public Message findAllWithRole() {
        return MessageUtil.success("success", userService.findAllWithRole());
    }

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", userService.findAll());
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return MessageUtil.success("保存或者更新成功");
    }

    @ApiOperation(value = "deleteById（通过ID删除产品信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @PostMapping("/deleteById")
    public Message deleteById(Long id) {
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
