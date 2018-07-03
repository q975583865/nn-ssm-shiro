package com.qppi.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.ArrangeWork;
import com.qppi.crud.bean.ArrangeWorkExample;
import com.qppi.crud.bean.CarInfo;
import com.qppi.crud.bean.CarInfoExample;
import com.qppi.crud.bean.OfferPart;
import com.qppi.crud.bean.OfferPartExample;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.OrderInfoExample;
import com.qppi.crud.bean.Reception;
import com.qppi.crud.bean.ReceptionExample;
import com.qppi.crud.bean.WorkingHours;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.ArrangeWorkMapper;
import com.qppi.crud.dao.CarInfoMapper;
import com.qppi.crud.dao.ContactsInfoMapper;
import com.qppi.crud.dao.InfoRelayMapper;
import com.qppi.crud.dao.OfferPartMapper;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.dao.ReceptionMapper;
import com.qppi.crud.utils.Msg;

@Service
public class OrderInfoService {
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private CarInfoMapper carInfoMapper;
	@Autowired
	private ContactsInfoMapper contactsInfoMapper;
	@Autowired
	private ReceptionMapper receptionMapper;
	@Autowired
	private InfoRelayMapper infoRelayMapper;
	@Autowired
	private ArrangeWorkMapper arrangeWorkMapper;
	@Autowired
	private OfferPartMapper offerPartMapper;
	
	public void addOrderInfo(OrderInfo orderInfo) {
		orderInfo.setId(BaseController.uuid());
		orderInfo.setCreateDate(new Date());
		orderInfo.setOrderState(String.valueOf(OrderStatus.INITIALIZATION.getIndex()));
		orderInfoMapper.insertSelective(orderInfo);
	}

	public List<OrderInfo>  getOrderByWorker(String workId,OrderInfo orderInfo) {
		ArrangeWorkExample arrangeWorkExample=new ArrangeWorkExample();
		ArrangeWorkExample.Criteria criteriaWork=arrangeWorkExample.createCriteria();
		criteriaWork.andWorkIdEqualTo(workId);
		List<ArrangeWork> arrangeWorks=arrangeWorkMapper.selectByExample(arrangeWorkExample);
		
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		OrderInfo orderInfo2=new OrderInfo();
		List<OrderInfo>  orderInfos=new ArrayList<>();
		for(ArrangeWork arrangeWork:arrangeWorks){
			criteria.andIdEqualTo(arrangeWork.getOrderId());
			if(StringUtils.isNotBlank(orderInfo.getOrderState())){
				criteria.andOrderStateEqualTo(orderInfo.getOrderState());
			}
			if(orderInfoMapper.selectByExample(example).size()==0){
				return null;
			}
			orderInfo2=orderInfoMapper.selectByExample(example).get(0);
			orderInfos.add(orderInfo2);
			for(int i=0;i<orderInfos.size()-1;i++){
				for(int j=i+1;j<orderInfos.size();j++){
					if(orderInfos.get(i).getId().equals(orderInfos.get(j).getId())){
						orderInfos.remove(orderInfos.get(j));
					}
				}
			}
		}
		return orderInfos;
	}

	public Msg updateWorkStatusConfirm(String workId,OrderInfo orderInfo) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderInfo.getId());
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.HAVECHECKED.getIndex()));
		
		List<OrderInfo>  list=orderInfoMapper.selectByExample(example);
		if(list.size()!=1){
			return Msg.fail().add("result", "订单不存在或状态异常！");
		}
		
		orderInfo.setOrderState(String.valueOf(OrderStatus.WORKING.getIndex()));
		orderInfoMapper.updateByExampleSelective(orderInfo, example);
		return Msg.success();
	}

	public void updateWorkStatusCompletion(OrderInfo orderInfo) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderInfo.getId());
		orderInfo.setOrderState(String.valueOf(OrderStatus.RESTORED.getIndex()));
		orderInfoMapper.updateByExampleSelective(orderInfo, example);
	}

	public List<OrderInfo> getOrderByMemAccount(String memAccount,OrderInfo orderInfo) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andContactTelEqualTo(memAccount);
		if(StringUtils.isNotBlank(orderInfo.getOrderState())){
			criteria.andOrderStateEqualTo(orderInfo.getOrderState());
		}
		return orderInfoMapper.selectByExample(example);
	}

/*	public Object getOrderBystatus(OrderInfo orderInfo) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		if(StringUtils.isNotBlank(orderInfo.getOrderState())){
			criteria.andOrderStateEqualTo(orderInfo.getOrderState());
		}
		return orderInfoMapper.selectByExample(example);
	}*/
	
	public OrderInfo getOrderByIdAndPhone(String orderId,String phone) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderId);
		criteria.andContactTelEqualTo(phone);
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.INITIALIZATION.getIndex()));
		List<OrderInfo> list=orderInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
	public OrderInfo getOrder(String orderId) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderId);
		List<OrderInfo> list=orderInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
	public OrderInfo getOrderById(String orderId,String createBy) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderId);
		criteria.andCreateByEqualTo(createBy);
		List<OrderInfo> list=orderInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	public void clearing(String id) {
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(id);
		orderInfo.setOrderState(String.valueOf(OrderStatus.PREPAID.getIndex()));
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
	
	}

	public void updateWorkStatusAgree(OrderInfo orderInfo) {
		OrderInfo orderInfo2=new OrderInfo();
		orderInfo2.setId(orderInfo.getId());
		orderInfo.setOrderState(String.valueOf(OrderStatus.AGREEREPAIR.getIndex()));
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo2);
	}

	public void updateWorkStatusNotAgree(OrderInfo orderInfo) {
		OrderInfo orderInfo2=new OrderInfo();
		orderInfo2.setId(orderInfo.getId());
		orderInfo.setOrderState(String.valueOf(OrderStatus.NOTAGREEREPAIR.getIndex()));
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo2);
	}

	public Msg ifNeedParts(String id,String ifNeedParts) {
		OrderInfo orderInfo=new OrderInfo();
		if(ifNeedParts.equals("1")){
			orderInfo.setOrderState(String.valueOf(OrderStatus.NEEDPARTS.getIndex()));
		}else {
			orderInfo.setOrderState(String.valueOf(OrderStatus.NOTNEEDPARTS.getIndex()));
		}
		
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.WORKING.getIndex()));
		List<OrderInfo> OrderInfos = orderInfoMapper.selectByExample(example);
		if(OrderInfos==null || OrderInfos.size()!=1){
			return Msg.fail().add("result", "失败，订单状态异常");
		}
		orderInfoMapper.updateByExampleSelective(orderInfo, example);
		return Msg.success();
	}

	public Msg waitConfirm(String id,String serviceId) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andCreateByEqualTo(serviceId);
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.NEEDPARTS.getIndex()));
		if(orderInfoMapper.selectByExample(example)==null){
			return Msg.fail().add("result", "失败，订单状态异常");
		}
		
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setOrderState(String.valueOf(OrderStatus.WAITCONFIRM.getIndex()));
		orderInfoMapper.updateByExampleSelective(orderInfo, example);
		return Msg.success();
	}

	public Msg isAgreeRepair(String orderId, String isAgreeRepair,
			String memberTel) {
		OrderInfo orderInfo=new OrderInfo();
		if(isAgreeRepair.equals("1")){
			orderInfo.setOrderState(String.valueOf(OrderStatus.AGREEREPAIR.getIndex()));
		}else {
			orderInfo.setOrderState(String.valueOf(OrderStatus.NOTAGREEREPAIR.getIndex()));
		}
		
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(orderId);
		criteria.andOrderStateEqualTo(String.valueOf(OrderStatus.WAITCONFIRM.getIndex()));
		if(orderInfoMapper.selectByExample(example)==null){
			return Msg.fail().add("result", "失败，订单状态异常");
		}
		orderInfoMapper.updateByExampleSelective(orderInfo, example);
		return Msg.success();
	}

	public PageInfo<OrderInfo> getOrdersByService(OrderInfo orderInfo,String userId, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andCreateByEqualTo(userId);
		if(StringUtils.isNotBlank(orderInfo.getOrderState())){
			criteria.andOrderStateEqualTo(orderInfo.getOrderState());
		}
		List<OrderInfo> list=orderInfoMapper.selectByExample(example);
		return new PageInfo<OrderInfo>(list);
	}

	public Msg getOrderDetailByService(OrderInfo orderInfo, String userId) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andCreateByEqualTo(userId);
		criteria.andIdEqualTo(orderInfo.getId());
		List<OrderInfo> listOrder=orderInfoMapper.selectByExample(example);
		if(listOrder.size()!=1){
			return Msg.fail().add("result", "系统异常1！");
		}
		orderInfo=listOrder.get(0);
		
		CarInfoExample carInfoExample=new CarInfoExample();
		CarInfoExample.Criteria criteria2=carInfoExample.createCriteria();
		criteria2.andIdEqualTo(orderInfo.getCarId());
		List<CarInfo> listCar=carInfoMapper.selectByExample(carInfoExample);
		if(listCar.size()!=1){
			return Msg.fail().add("result", "系统异常2！");
		}
		CarInfo carInfo=listCar.get(0);
		
		ReceptionExample receptionExample=new ReceptionExample();
		ReceptionExample.Criteria criteria4=receptionExample.createCriteria();
		criteria4.andOrderIdEqualTo(orderInfo.getId());	
		List<Reception> listReception=receptionMapper.selectByExample(receptionExample);
		if(listReception.size()!=1){
			return Msg.fail().add("result", "系统异常3！");
		}
		Reception reception=listReception.get(0);
		
		ArrangeWorkExample arrangeWorkExample=new ArrangeWorkExample();
		ArrangeWorkExample.Criteria criteria6=arrangeWorkExample.createCriteria();
		criteria6.andOrderIdEqualTo(orderInfo.getId());
		List<ArrangeWork> listArrangeWork=arrangeWorkMapper.selectByExample(arrangeWorkExample);
		ArrangeWork arrangeWork=listArrangeWork.get(0);
		
		OfferPartExample offerPartExample=new OfferPartExample();
		OfferPartExample.Criteria criteria7=offerPartExample.createCriteria();
		criteria7.andOrderIdEqualTo(orderInfo.getId());
		List<OfferPart> listOfferPart=offerPartMapper.selectByExample(offerPartExample);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("orderInfo", orderInfo);
		map.put("carInfo", carInfo);
		map.put("reception", reception);
		map.put("arrangeWork", arrangeWork);
		map.put("offerPart", listOfferPart);
		
		return Msg.success().add("result", map);
	}

	public Boolean compareStatus(WorkingHours workingHours) {
		OrderInfoExample example=new OrderInfoExample();
		OrderInfoExample.Criteria criteria=example.createCriteria();
		criteria.andCreateByEqualTo(workingHours.getCreateBy());
		criteria.andIdEqualTo(workingHours.getOrderId());
		criteria.andOrderStateEqualTo(OrderStatus.RESTORED.toString());
		
		List<OrderInfo> list=orderInfoMapper.selectByExample(example);
		if(list.size()!=1 || list==null){
			return false;
		}
		return true;
	}
}
