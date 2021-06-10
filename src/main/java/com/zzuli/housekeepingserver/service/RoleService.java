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
    List<Role> findAll();

    /**
     * 根据编号ID查找角色，一个id只有一种类型的编号
     *
     * @param id 编号
     * @return Role
     */
    Role findById(Long id);

    /**
     * 查询角色带权限
     *
     * @param id 编号
     * @return List<RoleExtend>
     */
    List<RoleExtend> findWithPrivilegeById(Long id);

    void saveOrUpdate(Role role) throws CustomerException;

    void deleteById(Long id) throws CustomerException;
}
