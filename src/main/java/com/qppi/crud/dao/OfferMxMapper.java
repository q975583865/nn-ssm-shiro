package com.qppi.crud.dao;

import com.qppi.crud.bean.OfferMx;
import com.qppi.crud.bean.OfferMxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfferMxMapper {
    long countByExample(OfferMxExample example);

    int deleteByExample(OfferMxExample example);

    int deleteByPrimaryKey(String id);

    int insert(OfferMx record);

    int insertSelective(OfferMx record);

    List<OfferMx> selectByExample(OfferMxExample example);

    OfferMx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OfferMx record, @Param("example") OfferMxExample example);

    int updateByExample(@Param("record") OfferMx record, @Param("example") OfferMxExample example);

    int updateByPrimaryKeySelective(OfferMx record);

    int updateByPrimaryKey(OfferMx record);
}