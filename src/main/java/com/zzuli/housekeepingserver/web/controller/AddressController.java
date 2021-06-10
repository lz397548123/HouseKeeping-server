package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Address;
import com.zzuli.housekeepingserver.service.AddressService;
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
 * liang         2021/6/4       地址管理接口
 */

@RestController
@RequestMapping("/address")
@Api(description = "地址管理接口")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "查询所有地址信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", addressService.findAll());
    }

    @ApiOperation(value = "通过id查询地址信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", addressService.findById(id));
    }

    @ApiOperation(value = "通过用户id查询地址信息")
    @ApiImplicitParam(name = "userId", value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("/findByUserId")
    public Message findByUserId(Long userId) {
        return MessageUtil.success("success", addressService.findByUserId(userId));
    }

    @ApiOperation(value = "保存或更新地址信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Address address) {
        addressService.saveOrUpdate(address);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除地址信息")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "级联查询用户地址信息")
    @GetMapping("/findAllWithUser")
    public Message findAllWithUser() {
        return MessageUtil.success("success", addressService.findAllWithUser());
    }
}
