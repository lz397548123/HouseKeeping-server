package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.bean.AccountEmployeeExample;
import com.zzuli.housekeepingserver.dao.AccountEmployeeMapper;
import com.zzuli.housekeepingserver.service.AccountEmployeeService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       员工账户管理业务实现类
 */

@Service
public class AccountEmployeeServiceImpl implements AccountEmployeeService {

    @Resource
    private AccountEmployeeMapper accountEmployeeMapper;

    @Override
    public List<AccountEmployee> findAll() {
        return accountEmployeeMapper.selectByExample(new AccountEmployeeExample());
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        AccountEmployee accountEmployee = accountEmployeeMapper.selectByPrimaryKey(id);
        if (accountEmployee == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        accountEmployeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountEmployee accountEmployee) throws CustomerException {
        if (accountEmployee.getId() != null) {
            accountEmployeeMapper.updateByPrimaryKey(accountEmployee);
        } else {
            accountEmployeeMapper.insert(accountEmployee);
        }
    }
}
