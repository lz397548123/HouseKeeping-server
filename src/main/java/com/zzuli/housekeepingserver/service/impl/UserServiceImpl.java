package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.UserExample;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;
import com.zzuli.housekeepingserver.dao.UserMapper;
import com.zzuli.housekeepingserver.dao.extend.UserExtendMapper;
import com.zzuli.housekeepingserver.service.UserService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3       用户业务实现类
 */

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> findAllEmployee() {
        return userExtendMapper.selectAllEmployee();
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(User user) throws CustomerException {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserExtend> findAllWithRole() {
        return userExtendMapper.selectAllWithRole();
    }

    @Override
    public List<User> findExample(User user) throws CustomerException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        // 不去重
        example.setDistinct(false);

        // 姓名模糊查询
        if (user.getRealname() != null) {
            criteria.andRealnameLike('%' + user.getRealname() + '%');
        }
        // 电话号码模糊查询
        if (user.getTelephone() != null) {
            criteria.andTelephoneLike('%' + user.getTelephone() + '%');
        }
        // 用户性别查询
        if (user.getGender() != null) {
            criteria.andGenderEqualTo(user.getGender());
        }
        // 状态查询
        if (user.getStatus() != null) {
            criteria.andStatusEqualTo(user.getStatus());
        }

        List<User> list = userMapper.selectByExample(example);
        return list;
    }
}
