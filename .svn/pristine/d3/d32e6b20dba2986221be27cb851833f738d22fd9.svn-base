package com.qppi.crud.dao;

import com.qppi.crud.bean.WorkMx;
import com.qppi.crud.bean.WorkMxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMxMapper {
    long countByExample(WorkMxExample example);

    int deleteByExample(WorkMxExample example);

    int deleteByPrimaryKey(String id);

    int insert(WorkMx record);

    int insertSelective(WorkMx record);

    List<WorkMx> selectByExample(WorkMxExample example);

    WorkMx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkMx record, @Param("example") WorkMxExample example);

    int updateByExample(@Param("record") WorkMx record, @Param("example") WorkMxExample example);

    int updateByPrimaryKeySelective(WorkMx record);

    int updateByPrimaryKey(WorkMx record);
}