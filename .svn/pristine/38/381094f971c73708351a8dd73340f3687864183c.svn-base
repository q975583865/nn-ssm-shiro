package com.qppi.crud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.ArrangeWork;
import com.qppi.crud.bean.ArrangeWorkExample;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.WorkMx;
import com.qppi.crud.bean.WorkMxExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.ArrangeWorkMapper;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.dao.WorkMxMapper;
import com.qppi.crud.utils.Msg;

@Service
public class ArrangeWorkService {
	
	@Autowired
	private ArrangeWorkMapper arrangeWorkMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private WorkMxMapper workMxMapper;

	public void addArrangeWork(ArrangeWork arrangeWork) {
		arrangeWork.setId(BaseController.uuid());
		arrangeWork.setCreateDate(new Date());
		arrangeWorkMapper.insertSelective(arrangeWork);
		
		OrderInfo info=new OrderInfo();
		info.setId(arrangeWork.getOrderId());
		orderInfoMapper.updateByPrimaryKeySelective(info);
		
		for(WorkMx workMx:arrangeWork.getWorkMxs()){
			workMx.setId(BaseController.uuid());
			workMx.setWorkId(arrangeWork.getId());
			workMxMapper.insertSelective(workMx);
		}
	}

	public Msg getArrangeWork(String createById,String arrangeWorkId) {
		ArrangeWorkExample example=new ArrangeWorkExample();
		ArrangeWorkExample.Criteria criteria=example.createCriteria();
		criteria.andWorkIdEqualTo(createById);
		criteria.andIdEqualTo(arrangeWorkId);
		List<ArrangeWork> list =arrangeWorkMapper.selectByExample(example);
		if(list.size()!=1 || list==null){
			return Msg.success().add("result", "查询不到派工单");
		}
		
		WorkMxExample workMxExample=new WorkMxExample();
		WorkMxExample.Criteria criteria2=workMxExample.createCriteria();
		criteria2.andWorkIdEqualTo(arrangeWorkId);
		return Msg.success().add("result", workMxMapper.selectByExample(workMxExample)); 
	}

	public Msg addWorkMx(ArrangeWork arrangeWork) {
		return Msg.success().add("result", workMxMapper.selectByPrimaryKey(arrangeWork.getId()));
	}

	public Object getArrangeWorkList(String id) {
		ArrangeWorkExample example=new ArrangeWorkExample();
		ArrangeWorkExample.Criteria criteria=example.createCriteria();
		criteria.andWorkIdEqualTo(id);
		return arrangeWorkMapper.selectByExample(example);
	}

	public List<ArrangeWork> getArrangeWorkByService(String serviceId, String orderId) {
		ArrangeWorkExample example=new ArrangeWorkExample();
		ArrangeWorkExample.Criteria criteria=example.createCriteria();
		criteria.andCreateByEqualTo(serviceId);
		criteria.andOrderIdEqualTo(orderId);
		return arrangeWorkMapper.selectByExample(example);
	}

	public List<WorkMx> getArrangeWorkMxByService(String arrangeWorkId) {
		WorkMxExample example=new WorkMxExample();
		WorkMxExample.Criteria criteria=example.createCriteria();
		criteria.andWorkIdEqualTo(arrangeWorkId);
		return workMxMapper.selectByExample(example);
	}

}
