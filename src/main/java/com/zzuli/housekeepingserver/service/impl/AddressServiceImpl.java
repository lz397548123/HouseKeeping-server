package com.zzuli.housekeepingserver.service.impl;

import com.zzuli.housekeepingserver.bean.Address;
import com.zzuli.housekeepingserver.bean.AddressExample;
import com.zzuli.housekeepingserver.bean.extend.AddressExtend;
import com.zzuli.housekeepingserver.dao.AddressMapper;
import com.zzuli.housekeepingserver.dao.extend.AddressExtendMapper;
import com.zzuli.housekeepingserver.service.AddressService;
import com.zzuli.housekeepingserver.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       地址业务实现类
 */

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AddressExtendMapper addressExtendMapper;

    @Override
    public List<Address> findAll() {
        return addressMapper.selectByExample(new AddressExample());
    }

    @Override
    public Address findById(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Address> findByUserId(Long userId) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(userId);
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public void saveOrUpdate(Address address) throws CustomerException {
        if (address.getId() != null) {
            addressMapper.updateByPrimaryKey(address);
        } else {
            addressMapper.insert(address);
        }
    }

    @Override
    public void deleteById(Long id) throws CustomerException {
        // 先判断该id对应的数据存在不？
        Address address = addressMapper.selectByPrimaryKey(id);
        if (address == null) {
            // 当不存在，报错！删除
            throw new CustomerException("删除失败,要删除的数据不存在");
        }
        // 当存在，删除
        addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AddressExtend> findAllWithUser() {
        return addressExtendMapper.selectAllWithUser();
    }
}
