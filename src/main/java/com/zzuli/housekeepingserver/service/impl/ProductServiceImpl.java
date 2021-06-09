package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Product;
import com.zzuli.housekeepingserver.bean.ProductExample;
import com.zzuli.housekeepingserver.bean.extend.ProductExtend;
import com.zzuli.housekeepingserver.dao.ProductMapper;
import com.zzuli.housekeepingserver.dao.extend.ProductExtendMapper;
import com.zzuli.housekeepingserver.service.ProductService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2       产品业务实现类
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductExtendMapper productExtendMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectByExample(new ProductExample());
    }

    @Override
    public void saveOrUpdate(Product product) throws CustomerException {
        if (product.getId() != null) {
            productMapper.updateByPrimaryKey(product);
        } else {
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductExtend> findAllWithCategory() {
        return productExtendMapper.selectAllWithCategory();
    }
}
