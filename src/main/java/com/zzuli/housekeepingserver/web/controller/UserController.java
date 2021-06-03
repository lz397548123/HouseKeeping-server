package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;
import com.zzuli.housekeepingserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询所有用户，并且级联获得用户角色
     * @return List<UserExtend>
     */
    @GetMapping("/findAllWithRole")
    public List<UserExtend> findAllWithRole() {
        return userService.findAllWithRole();
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return "保存或者更新成功";
    }

    @PostMapping("/deleteById")
    public String deleteById(Long id) {
        userService.deleteById(id);
        return "删除成功";
    }
}
