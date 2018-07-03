package com.qppi.crud.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.CarInfo;
import com.qppi.crud.bean.MemberInfo;
import com.qppi.crud.bean.MemberInfoExample;
import com.qppi.crud.bean.SysAuthUser;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.MemberInfoMapper;
import com.qppi.crud.dao.SysAuthUserMapper;
import com.qppi.crud.utils.MD5;

@Service
public class MemberInfoService {
	
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private SysAuthUserMapper sysAuthUserMapper;
	@Value("${memberInfoAuth}")  
	private String sysServiceAuth;

	public void addMemberInfo(MemberInfo memberInfo) {
		memberInfo.setId(BaseController.uuid());
		memberInfo.setCreateDate(new Date());
		memberInfo.setMemPassword(MD5.toMD5(memberInfo.getMemPassword()));
		memberInfoMapper.insertSelective(memberInfo);
		
		SysAuthUser sysAuthUser=new SysAuthUser();
		sysAuthUser.setMemId(memberInfo.getId());
		
		String[] auths=sysServiceAuth.split(",");
		for(String auth:auths){
			sysAuthUser.setAuthId(auth);
			sysAuthUserMapper.insertSelective(sysAuthUser);
		}
	}

	public MemberInfo getUserByPwd(String memAccount) {
		MemberInfoExample example=new MemberInfoExample();
		MemberInfoExample.Criteria criteria=example.createCriteria();
		criteria.andMemAccountEqualTo(memAccount);
		List<MemberInfo> list= memberInfoMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	public List<MemberInfo> getMemberInfoBy(MemberInfo memberInfo) {
		MemberInfoExample example=new MemberInfoExample();
		MemberInfoExample.Criteria criteria=example.createCriteria();
		
		if(StringUtils.isNotBlank(memberInfo.getMemAccount())){
			criteria.andMemAccountEqualTo(memberInfo.getMemAccount());
		}
		return memberInfoMapper.selectByExample(example);
	}

	public void updateMemberInfo(MemberInfo memberInfo) {
		memberInfo.setMemAccount(memberInfo.getMemTel());
		memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
	}

	public void addMemCarId(MemberInfo memberInfo, CarInfo carInfo) {
		memberInfo.setCarId(carInfo.getId());
		memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
	}

	public List<MemberInfo> getMemberInfoByCar(String id) {
		MemberInfoExample example=new MemberInfoExample();
		MemberInfoExample.Criteria criteria=example.createCriteria();
			criteria.andCarIdEqualTo(id);
		return memberInfoMapper.selectByExample(example);
	}
	
}
