package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.User;
import com.zzuli.housekeepingserver.bean.UserExample;
import com.zzuli.housekeepingserver.bean.extend.UserExtend;
import com.zzuli.housekeepingserver.dao.UserMapper;
import com.zzuli.housekeepingserver.dao.extend.UserExtendMapper;
import com.zzuli.housekeepingserver.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/3
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
    public void saveOrUpdate(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserExtend> findAllWithRole() {
        return userExtendMapper.selectAllWithRole();
    }
}
