package com.qppi.crud.auth;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qppi.crud.bean.MemberInfo;
import com.qppi.crud.bean.SysUser;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.service.MemberInfoService;
import com.qppi.crud.service.SysUserService;

/**
 * 登录系统后，对用户进行检验，包括严重和授权
 * 
 * @author dj
 * 
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory
			.getLogger(ShiroDbRealm.class);

	@Resource
	private MemberInfoService memberInfoService;
	@Autowired
	private SysUserService sysUserService;

	// 设置密码加密方式为MD5
	public ShiroDbRealm() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");
		setCredentialsMatcher(matcher);

	}
	
	// 用户验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("----------进入shiro验证方法");
		if (token.getPrincipal() == null){
			System.out.println("用户名为空--退出验证方法");
			return null;
			}
		
		MemberInfo memberInfo = null;
		SysUser sysUser=null;
		String username = (String) token.getPrincipal();
		try {
			 memberInfo= memberInfoService.getUserByPwd(username);
			  sysUser= sysUserService.getUserByPwd(username);
		} catch (Exception e) {
			log.error("query user exception", e);
		}
		
		
		if (memberInfo != null) {
			return new SimpleAuthenticationInfo(memberInfo, memberInfo.getMemPassword(), getName());
		}
		if(sysUser!=null){
			return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), getName());
		}
		return null;
	}

	// 用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Map<String, String> map=BaseController.getCurrentInfo();
		System.out.println("------当前账号："+map.get("username")+"     id:"+map.get("id"));
		Object object= principals.fromRealm(getName()).iterator()
		.next();
		
		SysUser ru = null;
		MemberInfo memberInfo = null;
		if(object instanceof MemberInfo){
			 memberInfo= (MemberInfo) object;
		}
		if(object instanceof SysUser){
			 ru =(SysUser) object;
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (memberInfo != null) {
			List<String> authCodeList= sysUserService.getAuthList(memberInfo.getId(),"m");
			for (String r : authCodeList) {
				info.addStringPermission(StringUtils.trim(r));
				System.out.println("权限列表："+r);
			}
		}
		
		if(ru!=null){
			List<String> authCodeList= sysUserService.getAuthList(ru.getId(),"s");
			for (String r : authCodeList) {
				info.addStringPermission(StringUtils.trim(r));
				System.out.println("权限列表："+r);
			}
		}
		return info;
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		return super.supports(token);
	}
}

