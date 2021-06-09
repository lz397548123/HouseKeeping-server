package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Role;
import com.zzuli.housekeepingserver.bean.extend.RoleExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       权限业务接口
 */

public interface RoleService {
    List<RoleExtend> findWithPrivilegeById(Long id);

    Role findById(Long id);

    void deleteById(Long id) throws CustomerException ;

    void saveOrUpdate(Role role) throws CustomerException ;
}
