package com.qppi.crud.dao;

import com.qppi.crud.bean.ContactsInfo;
import com.qppi.crud.bean.ContactsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactsInfoMapper {
    long countByExample(ContactsInfoExample example);

    int deleteByExample(ContactsInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(ContactsInfo record);

    int insertSelective(ContactsInfo record);

    List<ContactsInfo> selectByExample(ContactsInfoExample example);

    ContactsInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ContactsInfo record, @Param("example") ContactsInfoExample example);

    int updateByExample(@Param("record") ContactsInfo record, @Param("example") ContactsInfoExample example);

    int updateByPrimaryKeySelective(ContactsInfo record);

    int updateByPrimaryKey(ContactsInfo record);
}