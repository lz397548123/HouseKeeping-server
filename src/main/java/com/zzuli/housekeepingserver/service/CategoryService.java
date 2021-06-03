package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2       栏目业务接口
 */

public interface CategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category);

    void deleteById(Long id);

    List<CategoryExtend> findAllWithChild();

}
