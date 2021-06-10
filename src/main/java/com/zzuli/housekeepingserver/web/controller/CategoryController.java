package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.service.CategoryService;
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
 * liang         2021/6/3      栏目控制器
 */

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询所有分类信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", categoryService.findAll());
    }

    @ApiOperation(value = "通过id查询分类信息")
    @ApiImplicitParam(name = "id", value = "类别唯一编号", required = true, paramType = "query")
    @GetMapping("/findById")
    public Message findById(long id) {
        return MessageUtil.success("success", categoryService.findById(id));
    }

    @ApiOperation(value = "保存或更新分类信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Category category) {
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "通过id删除栏目信息")
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "查询分类树")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("success", categoryService.findAllWithChild());
    }

}
