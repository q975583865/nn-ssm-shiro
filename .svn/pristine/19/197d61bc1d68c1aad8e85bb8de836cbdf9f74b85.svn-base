package com.qppi.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qppi.crud.bean.SysAuth;
import com.qppi.crud.bean.SysAuthExample;
import com.qppi.crud.bean.SysAuthUser;
import com.qppi.crud.bean.SysAuthUserExample;
import com.qppi.crud.bean.SysUser;
import com.qppi.crud.bean.SysUserExample;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.SysAuthMapper;
import com.qppi.crud.dao.SysAuthUserMapper;
import com.qppi.crud.dao.SysUserMapper;
import com.qppi.crud.utils.MD5;
import com.qppi.crud.utils.Msg;

@Service
public class SysUserService {

	@Autowired
	SysUserMapper sysUserMapper;
	@Autowired
	private SysAuthUserMapper sysAuthUserMapper;
	@Autowired
	private SysAuthMapper sysAuthMapper;
	@Value("${sysServiceAuth}")  
	private String sysServiceAuth;
	@Value("${sysWorkAuth}")  
	private String sysWorkAuth;
	

	public void addSysUserService(SysUser sysUser) {
		sysUser.setCreateDate(new Date());
		sysUser.setId(BaseController.uuid());
		sysUser.setOfficeId("10");//默认10是项目部
		sysUser.setPassword(MD5.toMD5(sysUser.getPassword()));
		sysUser.setUserType("8");//默认8是服务顾问
		sysUserMapper.insertSelective(sysUser);
		
		SysAuthUser sysAuthUser=new SysAuthUser();
		sysAuthUser.setUserId(sysUser.getId());
		
		String[] auths=sysServiceAuth.split(",");
		for(String auth:auths){
			sysAuthUser.setAuthId(auth);
			sysAuthUserMapper.insertSelective(sysAuthUser);
		}
	}
	
	public void addSysUserWork(SysUser sysUser) {
		sysUser.setCreateDate(new Date());
		sysUser.setId(BaseController.uuid());
		sysUser.setOfficeId("10");//默认10是项目部
		sysUser.setPassword(MD5.toMD5(sysUser.getPassword()));
		sysUser.setUserType("9");//默认9是技师
		sysUserMapper.insertSelective(sysUser);
		
		SysAuthUser sysAuthUser=new SysAuthUser();
		sysAuthUser.setUserId(sysUser.getId());
		
		String[] auths=sysWorkAuth.split(",");
		for(String auth:auths){
			sysAuthUser.setAuthId(auth);
			sysAuthUserMapper.insertSelective(sysAuthUser);
		}
	}

	public List<SysUser> selectByPhoneOrEamil(SysUser sysUser) {
		SysUserExample example=new SysUserExample();
		SysUserExample.Criteria criteria =example.createCriteria();
		criteria.andLoginNameEqualTo(sysUser.getLoginName());
		return sysUserMapper.selectByExample(example);
	}

	public SysUser getUserByPwd(String loginName) {
		SysUserExample example=new SysUserExample();
		SysUserExample.Criteria criteria =example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		/*criteria.andUserTypeEqualTo("8");*/
		List<SysUser> list=sysUserMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
	/*public SysUser getUserByPwd1(String loginName, String password) {
		SysUserExample example=new SysUserExample();
		SysUserExample.Criteria criteria =example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		criteria.andPasswordEqualTo(password);
		criteria.andUserTypeEqualTo("9");
		List<SysUser> list=sysUserMapper.selectByExample(example);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}*/

	public Msg getWorkerList() {
		SysUserExample example=new SysUserExample();
		SysUserExample.Criteria criteria =example.createCriteria();
		criteria.andUserTypeEqualTo("9");
		return Msg.success().add("result", sysUserMapper.selectByExample(example));
	}



	public List<String> getAuthList(String id, String code) {
		SysAuthUserExample example=new SysAuthUserExample();
		SysAuthUserExample.Criteria criteria=example.createCriteria();
		if(code.equals("m")){
			criteria.andMemIdEqualTo(id);
		}
		if(code.equals("s")){
			criteria.andUserIdEqualTo(id);
		}
		
		List<SysAuthUser> sysAuthUsers=sysAuthUserMapper.selectByExample(example);
		
		List<String> list=new ArrayList<>();
		for(SysAuthUser sysAuthUser:sysAuthUsers){
			SysAuthExample sysAuthExample=new SysAuthExample();
			SysAuthExample.Criteria criteria2=sysAuthExample.createCriteria();
			criteria2.andIdEqualTo(sysAuthUser.getAuthId());
			for(SysAuth sysAuth:sysAuthMapper.selectByExample(sysAuthExample) ){
				list.add(sysAuth.getAuthCode());
			}
		}
		 return list;
	}

	public void addSysUserManage(SysUser sysUser) {
		sysUser.setCreateDate(new Date());
		sysUser.setId(BaseController.uuid());
		sysUser.setOfficeId("0");//默认0是系统管理员
		sysUser.setPassword(MD5.toMD5(sysUser.getPassword()));
		sysUserMapper.insertSelective(sysUser);
		
		SysAuthUser sysAuthUser=new SysAuthUser();
		sysAuthUser.setUserId(sysUser.getId());
		
		SysAuthExample sysAuthExample=new SysAuthExample();
		List<SysAuth> list=sysAuthMapper.selectByExample(sysAuthExample);
		
		for(SysAuth auth:list){
			sysAuthUser.setAuthId(auth.getId());
			sysAuthUserMapper.insertSelective(sysAuthUser);
		}
	}


}
