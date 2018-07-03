package com.qppi.crud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.OrderInfoExample;
import com.qppi.crud.bean.Reception;
import com.qppi.crud.bean.ReceptionExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.dao.ReceptionMapper;


@Service
public class ReceptionService{
	@Autowired
	private ReceptionMapper receptionMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	public void authOrderInfo(Reception reception) {
		ReceptionExample example=new ReceptionExample();
		ReceptionExample.Criteria criteria=example.createCriteria();
		criteria.andOrderIdEqualTo(reception.getOrderId());
		receptionMapper.updateByExampleSelective(reception, example);
		
		OrderInfoExample example1=new OrderInfoExample();
		OrderInfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andIdEqualTo(reception.getOrderId());
		OrderInfo orderInfo=new OrderInfo();
		if(reception.getIsAgree().equals("1") && reception.getMemInfo().equals("1")){
			orderInfo.setOrderState(String.valueOf(OrderStatus.HAVEAUTH.getIndex()));
		}else {
			orderInfo.setOrderState(String.valueOf(OrderStatus.NOTAGREEAUTH.getIndex()));
		}
		orderInfoMapper.updateByExampleSelective(orderInfo, example1);
	}

	public void checkOrderInfo(Reception reception) {
		ReceptionExample example=new ReceptionExample();
		ReceptionExample.Criteria criteria=example.createCriteria();
		criteria.andOrderIdEqualTo(reception.getOrderId());
		receptionMapper.updateByExampleSelective(reception, example);
		
		OrderInfoExample example1=new OrderInfoExample();
		OrderInfoExample.Criteria criteria1=example1.createCriteria();
		criteria1.andIdEqualTo(reception.getOrderId());
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setOrderState(OrderStatus.HAVECHECKED.getIndex()+"");
		orderInfoMapper.updateByExampleSelective(orderInfo, example1);
	}

	public void addReception(Reception reception) {
		reception.setId(BaseController.uuid());
		reception.setCreateDate(new Date());
		reception.setIsAgree(null);
		reception.setMemInfo(null);
		reception.setOrderId(reception.getOrderId());
		reception.setRecheckId(null);
		receptionMapper.insertSelective(reception);
	}

}
