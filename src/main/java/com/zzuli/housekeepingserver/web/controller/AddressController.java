package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Address;
import com.zzuli.housekeepingserver.service.impl.AddressServiceImpl;
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
 * liang         2021/6/4       地址管理接口
 */

@RestController
@RequestMapping("/address")
@Api(description = "地址管理接口")
public class AddressController {
    @Autowired
    private AddressServiceImpl addressService;

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Address address) {
        addressService.saveOrUpdate(address);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "findAllWithUserId（通过用户id查询地址信息）")
    @GetMapping("/findAllWithUserId")
    public Message findAllWithUserId(Long id) {
        return MessageUtil.success("success", addressService.findAllWithUserId(id));
    }

    @ApiOperation(value = "deleteById（通过ID删除分类信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
