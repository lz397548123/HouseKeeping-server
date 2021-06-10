package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountSystem;
import com.zzuli.housekeepingserver.bean.extend.AccountSystemExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       系统账户业务接口
 */

public interface AccountSystemService {
    List<AccountSystem> findAll();

    List<AccountSystemExtend> findAllWithOrderAndUser();

    AccountSystem findById(Long id);

    void deleteById(Long id) throws CustomerException;

    void saveOrUpdate(AccountSystem accountSystem) throws CustomerException;
}
