package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Role;
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
    public List<Role> findAll();

    public Role findById(Long id);

    public void deleteById(Long id) throws CustomerException ;

    public void saveOrUpdate(Role role) throws CustomerException ;
}
