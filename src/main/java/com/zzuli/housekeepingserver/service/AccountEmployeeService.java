package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       员工账户管理业务接口
 */

public interface AccountEmployeeService {
    List<AccountEmployee> findAll();

    void deleteById(Long id) throws CustomerException;

    void saveOrUpdate(AccountEmployee accountEmployee) throws CustomerException;
}
