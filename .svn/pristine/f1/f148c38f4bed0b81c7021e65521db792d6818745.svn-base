package com.qppi.crud.dao;

import com.qppi.crud.bean.SysAuthUser;
import com.qppi.crud.bean.SysAuthUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthUserMapper {
    long countByExample(SysAuthUserExample example);

    int deleteByExample(SysAuthUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAuthUser record);

    int insertSelective(SysAuthUser record);

    List<SysAuthUser> selectByExample(SysAuthUserExample example);

    SysAuthUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAuthUser record, @Param("example") SysAuthUserExample example);

    int updateByExample(@Param("record") SysAuthUser record, @Param("example") SysAuthUserExample example);

    int updateByPrimaryKeySelective(SysAuthUser record);

    int updateByPrimaryKey(SysAuthUser record);
}