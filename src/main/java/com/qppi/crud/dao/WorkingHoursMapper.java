package com.qppi.crud.dao;

import com.qppi.crud.bean.WorkingHours;
import com.qppi.crud.bean.WorkingHoursExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkingHoursMapper {
    long countByExample(WorkingHoursExample example);

    int deleteByExample(WorkingHoursExample example);

    int deleteByPrimaryKey(String id);

    int insert(WorkingHours record);

    int insertSelective(WorkingHours record);

    List<WorkingHours> selectByExample(WorkingHoursExample example);

    WorkingHours selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WorkingHours record, @Param("example") WorkingHoursExample example);

    int updateByExample(@Param("record") WorkingHours record, @Param("example") WorkingHoursExample example);

    int updateByPrimaryKeySelective(WorkingHours record);

    int updateByPrimaryKey(WorkingHours record);
}