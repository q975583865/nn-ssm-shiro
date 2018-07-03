package com.qppi.crud.dao;

import com.qppi.crud.bean.InfoRelay;
import com.qppi.crud.bean.InfoRelayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoRelayMapper {
    long countByExample(InfoRelayExample example);

    int deleteByExample(InfoRelayExample example);

    int deleteByPrimaryKey(String id);

    int insert(InfoRelay record);

    int insertSelective(InfoRelay record);

    List<InfoRelay> selectByExample(InfoRelayExample example);

    InfoRelay selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InfoRelay record, @Param("example") InfoRelayExample example);

    int updateByExample(@Param("record") InfoRelay record, @Param("example") InfoRelayExample example);

    int updateByPrimaryKeySelective(InfoRelay record);

    int updateByPrimaryKey(InfoRelay record);
}