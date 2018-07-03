package com.qppi.crud.dao;

import com.qppi.crud.bean.HoursMx;
import com.qppi.crud.bean.HoursMxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoursMxMapper {
    long countByExample(HoursMxExample example);

    int deleteByExample(HoursMxExample example);

    int deleteByPrimaryKey(String id);

    int insert(HoursMx record);

    int insertSelective(HoursMx record);

    List<HoursMx> selectByExample(HoursMxExample example);

    HoursMx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HoursMx record, @Param("example") HoursMxExample example);

    int updateByExample(@Param("record") HoursMx record, @Param("example") HoursMxExample example);

    int updateByPrimaryKeySelective(HoursMx record);

    int updateByPrimaryKey(HoursMx record);
}