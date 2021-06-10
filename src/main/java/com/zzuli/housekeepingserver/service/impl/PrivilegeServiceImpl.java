package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Privilege;
import com.zzuli.housekeepingserver.bean.PrivilegeExample;
import com.zzuli.housekeepingserver.bean.extend.PrivilegeExtend;
import com.zzuli.housekeepingserver.dao.PrivilegeMapper;
import com.zzuli.housekeepingserver.dao.extend.PrivilegeExtendMapper;
import com.zzuli.housekeepingserver.service.PrivilegeService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       权限业务实现类
 */

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;
    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;

    @Override
    public List<Privilege> findAll() {
        return privilegeMapper.selectByExample(new PrivilegeExample());
    }

    @Override
    public Privilege findById(Long id) {
        return privilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {
        if (privilege.getId() != null) {
            privilegeMapper.updateByPrimaryKey(privilege);
        } else {
            privilegeMapper.insert(privilege);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        Privilege privilege = privilegeMapper.selectByPrimaryKey(id);
        if (privilege == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        privilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PrivilegeExtend> findAllWithChild() {
        return privilegeExtendMapper.selectAllWithChild();
    }

    @Override
    public List<PrivilegeExtend> findWithRoleById(Long id) {
        return privilegeExtendMapper.selectWithRoleById(id);
    }


}
