package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountCustomer;
import com.zzuli.housekeepingserver.bean.extend.AccountCustomerExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       顾客业务接口
 */

public interface AccountCustomerService {
    List<AccountCustomer> findAll();

    AccountCustomer findById(Long id);

    void saveOrUpdate(AccountCustomer accountCustomer) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<AccountCustomerExtend> findAllWithOrderAndUser();
}
