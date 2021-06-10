package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Product;
import com.zzuli.housekeepingserver.service.ProductService;
import com.zzuli.housekeepingserver.service.impl.ProductServiceImpl;
import com.zzuli.housekeepingserver.utils.Message;
import com.zzuli.housekeepingserver.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "findAll（查询所有）")
    @GetMapping("/findAll")
    public Message findAll() {
        return MessageUtil.success("findAll（查询所有）success", productService.findAll());
    }

    /**
     * 查询所有产品，并且级联所属栏目
     *
     * @return Message
     */
    @ApiOperation(value = "findAllWithCategory（查询所有产品，并且级联所属栏目）")
    @GetMapping("/findAllWithCategory")
    public Message findAllWithCategory() {
        return MessageUtil.success("查询所有产品，并且级联所属栏目success", productService.findAllWithCategory());
    }

    @ApiOperation(value = "saveOrUpdate（保存或更新信息）")
    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Product product) {
        System.out.println(product.toString());
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存或更新信息成功");
    }

    @ApiOperation(value = "deleteById（通过ID删除产品信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id（唯一编号）", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        System.out.println(id);
        logger.debug(id.toString());
        productService.deleteById(id);
        return MessageUtil.success("通过ID删除产品信息成功");
    }

    @ApiOperation(value = "findProductById（通过ID查找产品信息（唯一））")
    @GetMapping("/findProductById")
    public Message findProductById(Long id) {
        return MessageUtil.success("通过ID查找产品成功", productService.findProductById(id));
    }

}
