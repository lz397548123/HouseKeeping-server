package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.bean.extend.AccountEmployeeExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       员工账户业务接口
 */

public interface AccountEmployeeService {
    List<AccountEmployee> findAll();

    AccountEmployee findById(Long id);

    void saveOrUpdate(AccountEmployee accountEmployee) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<AccountEmployeeExtend> findAllWithOrderAndUser();
}
