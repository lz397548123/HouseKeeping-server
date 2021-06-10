package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.RolePrivilege;
import com.zzuli.housekeepingserver.bean.extend.RolePrivilegeExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      角色权限业务接口
 */

public interface RolePrivilegeService {
    List<RolePrivilege> findAll();

    RolePrivilege findById(Long id);

    void saveOrUpdate(RolePrivilege rolePrivilege) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<RolePrivilegeExtend> findAllWithRoleAndPrivilege();
}
