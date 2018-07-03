package com.qppi.crud.dao;

import com.qppi.crud.bean.RepoIn;
import com.qppi.crud.bean.RepoInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepoInMapper {
    long countByExample(RepoInExample example);

    int deleteByExample(RepoInExample example);

    int deleteByPrimaryKey(String id);

    int insert(RepoIn record);

    int insertSelective(RepoIn record);

    List<RepoIn> selectByExample(RepoInExample example);

    RepoIn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RepoIn record, @Param("example") RepoInExample example);

    int updateByExample(@Param("record") RepoIn record, @Param("example") RepoInExample example);

    int updateByPrimaryKeySelective(RepoIn record);

    int updateByPrimaryKey(RepoIn record);
}