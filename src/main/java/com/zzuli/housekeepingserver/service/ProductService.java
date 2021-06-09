package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Product;
import com.zzuli.housekeepingserver.bean.extend.ProductExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/2      产品业务接口
 */

public interface ProductService {
    List<Product> findAll();

    void saveOrUpdate(Product product) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    Product findProductById(Long id);

    List<ProductExtend> findAllWithCategory();
}
