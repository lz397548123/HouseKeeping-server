package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Product;
import com.zzuli.housekeepingserver.bean.extend.ProductExtend;
import com.zzuli.housekeepingserver.service.impl.ProductServiceImpl;
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
 * liang         2021/6/3      产品控制器
 */

@RestController
@RequestMapping("/product")
@Api(description = "产品管理接口")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    /**
     * 查询所有产品，并且级联所属栏目
     * @return Message
     */
    @GetMapping("/findAllWithCategory")
    public Message findAllWithCategory() {
        List<ProductExtend> list = productService.findAllWithCategory();
        return MessageUtil.success(list);
    }

    @GetMapping("/findAll")
    public Message findAll() {
        List<Product> list = productService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过ID删除产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "唯一编号", required = true, paramType = "query")
    })
    @GetMapping("/deleteById")
    public Message deleteById(Long id) {
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(Product product) {
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存或更新成功");
    }


}
