package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.RolePrivilege;
import com.zzuli.housekeepingserver.bean.RolePrivilegeExample;
import com.zzuli.housekeepingserver.bean.extend.RolePrivilegeExtend;
import com.zzuli.housekeepingserver.dao.RolePrivilegeMapper;
import com.zzuli.housekeepingserver.dao.extend.RolePrivilegeExtendMapper;
import com.zzuli.housekeepingserver.service.RolePrivilegeService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date           Description
 * ============ =========== ============================
 * liang         2021/6/11      角色权限业务接口实现类
 */

@Service
public class RolePrivilegeServiceImpl implements RolePrivilegeService {
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;
    @Resource
    private RolePrivilegeExtendMapper rolePrivilegeExtendMapper;

    @Override
    public List<RolePrivilege> findAll() {
        return rolePrivilegeMapper.selectByExample(new RolePrivilegeExample());
    }

    @Override
    public RolePrivilege findById(Long id) {
        return rolePrivilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(RolePrivilege rolePrivilege) throws CustomerException {
        if (rolePrivilege.getId() == null) {
            rolePrivilegeMapper.insert(rolePrivilege);
        } else {
            if (rolePrivilegeMapper.selectByPrimaryKey(rolePrivilege.getId()) == null) {
                throw new CustomerException("修改失败，数据不存在");
            }
            rolePrivilegeMapper.updateByPrimaryKey(rolePrivilege);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        if (rolePrivilegeMapper.selectByPrimaryKey(id) == null) {
            throw new CustomerException("删除失败，数据不存在");
        }
        rolePrivilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RolePrivilegeExtend> findAllWithRoleAndPrivilege() {
        return rolePrivilegeExtendMapper.selectAllWithRoleAndPrivilege();
    }
}
