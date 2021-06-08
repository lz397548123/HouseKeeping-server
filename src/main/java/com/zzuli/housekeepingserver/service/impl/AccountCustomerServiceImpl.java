package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.AccountCustomer;
import com.zzuli.housekeepingserver.bean.AccountCustomerExample;
import com.zzuli.housekeepingserver.dao.AccountCustomerMapper;
import com.zzuli.housekeepingserver.service.AccountCustomerService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/8       用户账户管理业务实现类
 */

@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {
    @Resource
    private AccountCustomerMapper accountCustomerMapper;

    @Override
    public List<AccountCustomer> findAll() {
        return accountCustomerMapper.selectByExample(new AccountCustomerExample());
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        AccountCustomer accountCustomer = accountCustomerMapper.selectByPrimaryKey(id);
        if (accountCustomer == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        accountCustomerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountCustomer accountCustomer) throws CustomerException {
        if (accountCustomer.getId() != null) {
            accountCustomerMapper.updateByPrimaryKey(accountCustomer);
        } else {
            accountCustomerMapper.insert(accountCustomer);
        }
    }
}
