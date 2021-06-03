package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;
import com.zzuli.housekeepingserver.service.impl.CategoryServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * liang         2021/6/3      栏目控制器
 */

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理接口")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", categoryService.findAll());
    }

    /**
     * 查询所有栏目，并且级联所属子栏目
     * @return Message
     */
    @ApiOperation(value = "findAllWithChild（查询所有栏目，并且级联所属子栏目）")
    @GetMapping("/findAllWithChild")
    public Message findAllWithChild() {
        return MessageUtil.success("success", categoryService.findAllWithChild());
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Category category) {
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("保存或更新成功");
    }

    @ApiOperation(value = "deleteById（通过ID删除分类信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @PostMapping("/deleteById")
    public Message deleteById(Long id) {
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
