package com.qppi.crud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.InfoRelay;
import com.qppi.crud.dao.InfoRelayMapper;

@Service
public class InfoRelayService {

	@Autowired
	private InfoRelayMapper infoRelayMapper;

	public void failureInfoRelay(InfoRelay infoRelay) {
		infoRelay.setCreateDate(new Date());
		infoRelayMapper.insertSelective(infoRelay);
	}
	
}
