package com.qppi.crud.dao;

import com.qppi.crud.bean.PartBuy;
import com.qppi.crud.bean.PartBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartBuyMapper {
    long countByExample(PartBuyExample example);

    int deleteByExample(PartBuyExample example);

    int deleteByPrimaryKey(String id);

    int insert(PartBuy record);

    int insertSelective(PartBuy record);

    List<PartBuy> selectByExample(PartBuyExample example);

    PartBuy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PartBuy record, @Param("example") PartBuyExample example);

    int updateByExample(@Param("record") PartBuy record, @Param("example") PartBuyExample example);

    int updateByPrimaryKeySelective(PartBuy record);

    int updateByPrimaryKey(PartBuy record);
}