package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Category;
import com.zzuli.housekeepingserver.bean.CategoryExample;
import com.zzuli.housekeepingserver.bean.extend.CategoryExtend;
import com.zzuli.housekeepingserver.dao.CategoryMapper;
import com.zzuli.housekeepingserver.dao.extend.CategoryExtendMapper;
import com.zzuli.housekeepingserver.service.CategoryService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2       栏目业务实现类
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
    public Category findById(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if (category.getId() != null) {
            categoryMapper.updateByPrimaryKey(category);
        } else {
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }

}
