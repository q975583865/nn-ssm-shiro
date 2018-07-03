package com.qppi.crud.dao;

import com.qppi.crud.bean.OfferPart;
import com.qppi.crud.bean.OfferPartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfferPartMapper {
    long countByExample(OfferPartExample example);

    int deleteByExample(OfferPartExample example);

    int deleteByPrimaryKey(String id);

    int insert(OfferPart record);

    int insertSelective(OfferPart record);

    List<OfferPart> selectByExample(OfferPartExample example);

    OfferPart selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OfferPart record, @Param("example") OfferPartExample example);

    int updateByExample(@Param("record") OfferPart record, @Param("example") OfferPartExample example);

    int updateByPrimaryKeySelective(OfferPart record);

    int updateByPrimaryKey(OfferPart record);
}