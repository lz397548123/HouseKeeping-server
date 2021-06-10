package com.zzuli.housekeepingserver.dao;

import com.zzuli.housekeepingserver.bean.AccountSystem;
import com.zzuli.housekeepingserver.bean.AccountSystemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccountSystemMapper {
    @Select("select * from jz_account_system")
    List<AccountSystem> systemselectAll();

    @Select("select * from jz_account_system where id = #{id}")
    AccountSystem systemselectById(Long id);

    long countByExample(AccountSystemExample example);

    int deleteByExample(AccountSystemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountSystem record);

    int insertSelective(AccountSystem record);

    List<AccountSystem> selectByExample(AccountSystemExample example);

    AccountSystem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    int updateByExample(@Param("record") AccountSystem record, @Param("example") AccountSystemExample example);

    int updateByPrimaryKeySelective(AccountSystem record);

    int updateByPrimaryKey(AccountSystem record);
}
