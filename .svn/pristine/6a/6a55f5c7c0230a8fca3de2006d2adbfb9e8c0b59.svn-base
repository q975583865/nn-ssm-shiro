package com.qppi.crud.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.HoursMx;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.WorkingHours;
import com.qppi.crud.bean.WorkingHoursExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.HoursMxMapper;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.dao.WorkingHoursMapper;

@Service
public class WorkingHoursService {
	@Autowired
	private WorkingHoursMapper workingHoursMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private HoursMxMapper hoursMxMapper;


	public void addWorkingHours(WorkingHours workingHours) {
		workingHours.setId(BaseController.uuid());
		workingHours.setCreateDate(new Date());
		
		Double total=(double) 0;
		for(HoursMx hoursMx:workingHours.getHoursMxs()){
			hoursMx.setId(BaseController.uuid());
			hoursMx.setCreateDate(new Date());
			hoursMx.setHoursId(workingHours.getId());
			BigDecimal amount=new BigDecimal(hoursMx.getPrice());
			BigDecimal xkl=new BigDecimal(hoursMx.getXkl());
			hoursMx.setPriceE(amount.multiply(xkl).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			hoursMxMapper.insertSelective(hoursMx);
			
			total=total+hoursMx.getPriceE();
		}
		workingHours.setTotal(total);
		workingHoursMapper.insertSelective(workingHours);
		
		
		Double orderTotal=(double) 0;
		WorkingHoursExample workingHoursExample=new WorkingHoursExample();
		WorkingHoursExample.Criteria criteria =workingHoursExample.createCriteria();
		criteria.andOrderIdEqualTo(workingHours.getOrderId());
		
		for(WorkingHours workingHours2:workingHoursMapper.selectByExample(workingHoursExample)){
				orderTotal=orderTotal+workingHours2.getTotal();
		}
		
		OrderInfo orderInfo=orderInfoMapper.selectByPrimaryKey(workingHours.getOrderId());
		orderInfo.setId(workingHours.getOrderId());
		orderInfo.setOrderState(OrderStatus.PREPAID.toString());
		orderInfo.setTotalTime(orderTotal);
		orderInfo.setTotal(orderInfo.getTotalPart()+orderInfo.getTotalTime());
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
	}

	
}
