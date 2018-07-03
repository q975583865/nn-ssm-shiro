package com.qppi.crud.dao;

import com.qppi.crud.bean.Reception;
import com.qppi.crud.bean.ReceptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceptionMapper {
    long countByExample(ReceptionExample example);

    int deleteByExample(ReceptionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Reception record);

    int insertSelective(Reception record);

    List<Reception> selectByExample(ReceptionExample example);

    Reception selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Reception record, @Param("example") ReceptionExample example);

    int updateByExample(@Param("record") Reception record, @Param("example") ReceptionExample example);

    int updateByPrimaryKeySelective(Reception record);

    int updateByPrimaryKey(Reception record);
}