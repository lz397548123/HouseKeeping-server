package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.service.UserService;
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
 * liang         2021/6/3       用户控制器
 */

@RestController
@RequestMapping("/user")
@Api(description = "用户管理接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户权限")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", userService.findAll());
    }

    @ApiOperation(value = "查询角色为员工的用户")
    @GetMapping("/findAllEmployee")
    public Message findAllEmployee() {
        return MessageUtil.success(userService.findAllEmployee());
    }

    @ApiOperation(value = "审核员工")
    @GetMapping("、auditing")
    public Message auditing(Long id) {
        User user = userService.findById(id);
        user.setStatus("已通过");
        userService.saveOrUpdate(user);
        return MessageUtil.success("审核成功");
    }

    @GetMapping("/auditing1")
    public Message auditing1(Long id) {
        userService.deleteById(id);
        return MessageUtil.success("审核成功");
    }

    @GetMapping("/refuseAuditing1")
    public Message refuseAuditing1(Long id) {
        userService.deleteById(id);
        return MessageUtil.success("已拒绝审核");
    }

    @GetMapping("/refuseAuditing")
    public Message refuseAuditing(Long id) {
        User user = userService.findById(id);
        user.setStatus("未通过");
        userService.saveOrUpdate(user);
        return MessageUtil.success("已拒绝审核");
    }

    @ApiOperation(value = "通过id查询用户权限")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", userService.findById(id));
    }

    @ApiOperation(value = "保存或更新用户信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return MessageUtil.success("保存或者更新成功");
    }

    @ApiOperation(value = "通过ID删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }


    @ApiOperation(value = "findAllWithRole（查询所有用户，并且级联获得用户角色）")
    @GetMapping("/findAllWithRole")
    public Message findAllWithRole() {
        return MessageUtil.success("success", userService.findAllWithRole());
    }
}
