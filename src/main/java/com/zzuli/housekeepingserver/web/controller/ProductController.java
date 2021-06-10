package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Product;
import com.zzuli.housekeepingserver.service.ProductService;
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
 * liang         2021/6/3      产品控制器
 */

@RestController
@RequestMapping("/product")
@Api(description = "产品管理接口")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "查询所有产品信息")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("success", productService.findAll());
    }

    @ApiOperation(value = "通过id查询产品信息")
    @GetMapping("/findById")
    public Message findById(Long id) {
        return MessageUtil.success("success", productService.findById(id));
    }

    @ApiOperation(value = "保存或更新产品信息")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Product product) {
        System.out.println(product.toString());
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存或更新信息成功");
    }

    @ApiOperation(value = "通过id删除产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        productService.deleteById(id);
        return MessageUtil.success("通过ID删除产品信息成功");
    }

    @ApiOperation(value = "通过类别级联产品信息")
    @GetMapping("/findAllWithCategory")
    public Message findAllWithCategory() {
        return MessageUtil.success("success", productService.findAllWithCategory());
    }

}
