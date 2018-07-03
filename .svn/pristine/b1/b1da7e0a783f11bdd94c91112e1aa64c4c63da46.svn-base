package com.qppi.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.ContactsInfo;
import com.qppi.crud.bean.ContactsInfoExample;
import com.qppi.crud.dao.ContactsInfoMapper;

@Service
public class ContactsInfoService {
	
	@Autowired
	private ContactsInfoMapper contactsInfoMapper;


	public ContactsInfo getContactsByPhone(String phone) {
		ContactsInfoExample example=new ContactsInfoExample();
		ContactsInfoExample.Criteria  criteria= example.createCriteria();
		criteria.andContactTelEqualTo(phone);
		List<ContactsInfo> list=contactsInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	
}
