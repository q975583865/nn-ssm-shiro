package com.qppi.crud.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.service.MemberInfoService;
import com.qppi.crud.service.SysUserService;
import com.qppi.crud.utils.Msg;

/**
 * 系统登录，注销，首页等
 * 
 * @author huang
 * 
 */
@Controller
public class MainController extends BaseController {

	@Resource
	private MemberInfoService memberInfoService;
	@Autowired
	private SysUserService sysUserService;

	// 用户登录验证,用于提交form表单数据验证
	@RequestMapping(value = "/login")
	@ResponseBody
	public Msg login() {
		if(SecurityUtils.getSubject().isAuthenticated()){
			return Msg.success().add("result", "登陆成功！");
		}
		return Msg.fail().add("result", "没有登录！");
	}
				
				@RequestMapping(value = "/noAuth")
				@ResponseBody
				public Msg noAuth() {
					return Msg.fail().add("result", "没有权限！");
				}
}
