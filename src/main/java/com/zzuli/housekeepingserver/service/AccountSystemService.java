package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.AccountSystem;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       系统账户管理业务接口
 */

public interface AccountSystemService {
    List<AccountSystem> findAll();

    void deleteById(Long id) throws CustomerException;

    void saveOrUpdate(AccountSystem accountSystem) throws CustomerException;
}
