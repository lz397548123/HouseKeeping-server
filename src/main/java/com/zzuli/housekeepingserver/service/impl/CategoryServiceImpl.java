package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.CategoryExample;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;
import com.zzuli.housekeepingserver.dao.CategoryMapper;
import com.zzuli.housekeepingserver.dao.extend.CategoryExtendMapper;
import com.zzuli.housekeepingserver.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) {
        if (category.getId() != null) {
            categoryMapper.updateByPrimaryKey(category);
        } else {
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }

}
