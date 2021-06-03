package com.zzuli.housekeepingserver.web.controller;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;
import com.zzuli.housekeepingserver.service.impl.CategoryServiceImpl;
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
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/findAllWithChild")
    public List<CategoryExtend> findAllWithChild() {
        return categoryService.findAllWithChild();
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(Category category) {
        categoryService.saveOrUpdate(category);
        return "保存或更新成功";
    }

    @PostMapping("/deleteById")
    public String deleteById(Long id) {
        categoryService.deleteById(id);
        return "删除成功";
    }
}
