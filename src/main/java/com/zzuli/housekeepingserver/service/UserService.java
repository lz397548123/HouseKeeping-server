package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3
 */

public interface UserService {
    List<User> findAll();

    void saveOrUpdate(User user);

    void deleteById(Long id);

    List<UserExtend> findAllWithRole();
}
