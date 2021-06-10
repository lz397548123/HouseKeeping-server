package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.AccountSystem;
import com.zzuli.housekeepingserver.bean.AccountSystemExample;
import com.zzuli.housekeepingserver.bean.extend.AccountSystemExtend;
import com.zzuli.housekeepingserver.dao.AccountSystemMapper;
import com.zzuli.housekeepingserver.dao.extend.AccountSystemExtendMapper;
import com.zzuli.housekeepingserver.service.AccountSystemService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       用户系统业务实现类
 */

@Service
public class AccountSystemServiceImpl implements AccountSystemService {
    @Resource
    private AccountSystemMapper accountSystemMapper;
    @Resource
    private AccountSystemExtendMapper accountSystemExtendMapper;

    @Override
    public List<AccountSystem> findAll() {
        return accountSystemMapper.selectByExample(new AccountSystemExample());
    }

    @Override
    public AccountSystem findById(Long id) {
        return accountSystemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountSystem accountSystem) throws CustomerException {
        if (accountSystem.getId() == null) {
            accountSystemMapper.insert(accountSystem);
        } else {
            if (accountSystemMapper.selectByPrimaryKey(accountSystem.getId()) == null) {
                throw new CustomerException("修改失败，数据不存在");
            }
            accountSystemMapper.updateByPrimaryKey(accountSystem);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        AccountSystem accountSystem = accountSystemMapper.selectByPrimaryKey(id);
        if (accountSystem == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        accountSystemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AccountSystemExtend> findAllWithOrderAndUser() {
        return accountSystemExtendMapper.selectAllWithOrderAndUser();
    }
}
