package com.qppi.crud.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.OfferMx;
import com.qppi.crud.bean.OfferMxExample;
import com.qppi.crud.bean.OfferPart;
import com.qppi.crud.bean.OfferPartExample;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.OrderInfoExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.OfferMxMapper;
import com.qppi.crud.dao.OfferPartMapper;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.utils.Msg;

@Service
public class OfferPartService {

	@Autowired
	private OfferPartMapper offerPartMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private OfferMxMapper offerMxMapper;

	public Msg addOfferPart(OfferPart offerPart) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(offerPart.getOrderId());
		criteria.andCreateByEqualTo(offerPart.getCreateBy());
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.NEEDPARTS.getIndex()));
		if(orderInfoMapper.selectByExample(example)==null){
			return Msg.fail().add("result", "查询不到该订单或订单状态有误");
		}
		
		offerPart.setCreateDate(new Date());
		offerPart.setId(BaseController.uuid());
		
		Double	total=(double) 0;
		for(OfferMx offerMx:offerPart.getOfferMxs()){
			offerMx.setOfferId(offerPart.getId());
			offerMx.setCreateDate(new Date());
			offerMx.setId(BaseController.uuid());
			offerMx.setPartDate(offerMx.getPartDate());//货期 
			BigDecimal price=new BigDecimal(offerMx.getPrice());
			BigDecimal count=new BigDecimal(offerMx.getCount());
			offerMx.setTotal(price.multiply(count).doubleValue());
			//新增配件报价明细
			offerMxMapper.insertSelective(offerMx);
			total+=offerMx.getTotal();
		}
		//新增配件报价单
		offerPart.setTotal(total);
		offerPartMapper.insertSelective(offerPart);
		
		
		OfferPartExample offerPartExample=new OfferPartExample();
		OfferPartExample.Criteria criteria2=offerPartExample.createCriteria();
		criteria2.andOrderIdEqualTo(offerPart.getOrderId());
		 List<OfferPart> offerParts=offerPartMapper.selectByExample(offerPartExample);
		 Double	totalPart=(double) 0;
		for(OfferPart part:offerParts){
			totalPart=totalPart+part.getTotal();
		}
		
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(offerPart.getOrderId());
		orderInfo.setTotalPart(totalPart);
		orderInfo.setOrderState(String.valueOf(OrderStatus.WAITCONFIRM.getIndex()));
		//改订单价格
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
		
		return Msg.success();
	}

	public Object getOfferPartByOrder(OfferPart offerPart) {
		OfferPartExample example=new OfferPartExample();
		OfferPartExample.Criteria criteria=example.createCriteria();
		criteria.andOrderIdEqualTo(offerPart.getOrderId());
		return offerPartMapper.selectByExample(example);
	}

	public Object getOfferPartDetail(OfferMx offerMx) {
		OfferMxExample example=new OfferMxExample();
		OfferMxExample.Criteria criteria=example.createCriteria();
		criteria.andOfferIdEqualTo(offerMx.getOfferId());
		return offerMxMapper.selectByExample(example);
	}

	
	
}
