package com.qppi.crud.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.CarInfo;
import com.qppi.crud.bean.CarInfoExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.CarInfoMapper;
import com.qppi.crud.dao.ContactsInfoMapper;

@Service
public class CarInfoService {

	@Autowired
	private CarInfoMapper carInfoMapper;
	@Autowired
	private ContactsInfoMapper contactsInfoMapper;

	public CarInfo getCarInfo(CarInfo carInfo) {
		CarInfoExample example=new CarInfoExample();
		CarInfoExample.Criteria criteria=example.createCriteria();
		criteria.andCarnum1EqualTo(carInfo.getCarnum1());
		List<CarInfo> list=carInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return	null;
	}

	public CarInfo addCarInfo(CarInfo carInfo) {
		carInfo.setId(BaseController.uuid());
		carInfo.setCreateDate(new Date());
		carInfoMapper.insertSelective(carInfo);
		return carInfo;
	}
	
	
}
