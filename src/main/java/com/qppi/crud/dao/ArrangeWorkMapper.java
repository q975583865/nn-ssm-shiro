package com.qppi.crud.dao;

import com.qppi.crud.bean.ArrangeWork;
import com.qppi.crud.bean.ArrangeWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrangeWorkMapper {
    long countByExample(ArrangeWorkExample example);

    int deleteByExample(ArrangeWorkExample example);

    int deleteByPrimaryKey(String id);

    int insert(ArrangeWork record);

    int insertSelective(ArrangeWork record);

    List<ArrangeWork> selectByExample(ArrangeWorkExample example);

    ArrangeWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ArrangeWork record, @Param("example") ArrangeWorkExample example);

    int updateByExample(@Param("record") ArrangeWork record, @Param("example") ArrangeWorkExample example);

    int updateByPrimaryKeySelective(ArrangeWork record);

    int updateByPrimaryKey(ArrangeWork record);
}