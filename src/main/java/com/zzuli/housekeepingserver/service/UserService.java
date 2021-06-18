package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       用户业务接口
 */

public interface UserService {
    List<User> findAll();

    List<UserExtend> findAllEmployee();

    User findById(Long id);

    void saveOrUpdate(User user) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<UserExtend> findAllWithRole();

    // 多条件查询
    List<User> findExample(User user) throws CustomerException;
}
