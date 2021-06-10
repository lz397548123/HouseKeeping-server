package com.zzuli.housekeepingserver.dao;

import com.zzuli.housekeepingserver.bean.AccountEmployee;
import com.zzuli.housekeepingserver.bean.AccountEmployeeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccountEmployeeMapper {
    @Select("select * from jz_account_employee")
    List<AccountEmployee> employeeselectAll();

    @Select("select * from jz_account_employee where id = #{id}")
    AccountEmployee employeeselectById(Long id);

    long countByExample(AccountEmployeeExample example);

    int deleteByExample(AccountEmployeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountEmployee record);

    int insertSelective(AccountEmployee record);

    List<AccountEmployee> selectByExample(AccountEmployeeExample example);

    AccountEmployee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    int updateByExample(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    int updateByPrimaryKeySelective(AccountEmployee record);

    int updateByPrimaryKey(AccountEmployee record);
}
