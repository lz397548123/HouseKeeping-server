package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

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

    Category findById(Long id);

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<CategoryExtend> findAllWithChild();
}
