package com.qppi.crud.dao;

import com.qppi.crud.bean.RepoInfo;
import com.qppi.crud.bean.RepoInfoExample;
import com.qppi.crud.bean.RepoInfoPart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RepoInfoMapper {
    long countByExample(RepoInfoExample example);

    int deleteByExample(RepoInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(RepoInfo record);

    int insertSelective(RepoInfo record);

    List<RepoInfo> selectByExample(RepoInfoExample example);

    RepoInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RepoInfo record, @Param("example") RepoInfoExample example);

    int updateByExample(@Param("record") RepoInfo record, @Param("example") RepoInfoExample example);

    int updateByPrimaryKeySelective(RepoInfo record);

    int updateByPrimaryKey(RepoInfo record);

	List<RepoInfoPart> getRepoInfos(String num);

}