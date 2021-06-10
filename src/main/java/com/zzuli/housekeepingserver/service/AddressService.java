package com.zzuli.housekeepingserver.service;

import com.zzuli.housekeepingserver.bean.Address;
import com.zzuli.housekeepingserver.bean.extend.AddressExtend;
import com.zzuli.housekeepingserver.utils.CustomerException;

import java.util.List;

/**
 * 类说明：
 * Modify Information:
 * Author        Date          Description
 * ============ =========== ============================
 * liang         2021/6/4       地址业务接口
 */

public interface AddressService {
    List<Address> findAll();

    Address findById(Long id);

    List<Address> findByUserId(Long userId);

    void saveOrUpdate(Address address) throws CustomerException;

    void deleteById(Long id) throws CustomerException;

    List<AddressExtend> findAllWithUser();
}
