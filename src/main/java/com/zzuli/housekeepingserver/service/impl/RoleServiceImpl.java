package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Role;
import com.zzuli.housekeepingserver.bean.extend.RoleExtend;
import com.zzuli.housekeepingserver.dao.PrivilegeMapper;
import com.zzuli.housekeepingserver.dao.RoleMapper;
import com.zzuli.housekeepingserver.dao.RolePrivilegeMapper;
import com.zzuli.housekeepingserver.dao.extend.RoleExtendMapper;
import com.zzuli.housekeepingserver.service.RoleService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       权限业务实现
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleExtendMapper roleExtendMapper;


    /**
     * 查询角色带权限
     *
     * @param id 编号
     * @return List<RoleExtend>
     */
    @Override
    public List<RoleExtend> findWithPrivilegeById(Long id) {
        return roleExtendMapper.selectWithPrivilegeById(id);
    }

    /**
     * 根据编号ID查找角色，一个id只有一种类型的编号
     *
     * @param id 编号
     * @return Role
     */
    @Override
    public Role findById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Role role) throws CustomerException {
        if (role.getId() != null) {
            roleMapper.updateByPrimaryKey(role);
        } else {
            roleMapper.insert(role);
        }
    }
}
