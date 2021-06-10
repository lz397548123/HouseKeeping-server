package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.bean.extend.PrivilegeExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4     权限义务接口
 */

public interface PrivilegeService {
    List<Privilege> findAll();

    Privilege findById(Long id);

    void saveOrUpdate(Privilege privilege) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<PrivilegeExtend> findAllWithChild();

    List<PrivilegeExtend>  findWithRoleById(Long id);
}
