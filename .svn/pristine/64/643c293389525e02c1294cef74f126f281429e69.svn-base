package com.qppi.crud.dao;

import com.qppi.crud.bean.RepoOut;
import com.qppi.crud.bean.RepoOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepoOutMapper {
    long countByExample(RepoOutExample example);

    int deleteByExample(RepoOutExample example);

    int deleteByPrimaryKey(String id);

    int insert(RepoOut record);

    int insertSelective(RepoOut record);

    List<RepoOut> selectByExample(RepoOutExample example);

    RepoOut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RepoOut record, @Param("example") RepoOutExample example);

    int updateByExample(@Param("record") RepoOut record, @Param("example") RepoOutExample example);

    int updateByPrimaryKeySelective(RepoOut record);

    int updateByPrimaryKey(RepoOut record);
}