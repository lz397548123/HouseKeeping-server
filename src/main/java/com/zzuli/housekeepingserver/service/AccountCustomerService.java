package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountCustomer;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       用户账户管理业务接口
 */

public interface AccountCustomerService {
    List<AccountCustomer> findAll();

    void deleteById(Long id) throws CustomerException;

    void saveOrUpdate(AccountCustomer accountCustomer) throws CustomerException;
}
