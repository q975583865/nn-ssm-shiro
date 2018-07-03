package com.qppi.crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.MemberInfo;
import com.qppi.crud.service.MemberInfoService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("MemberInfoController")
public class MemberInfoController extends BaseController{
	@Autowired
	private MemberInfoService memberInfoService;
	
	/**会员注册
	 * @param memberInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping("addMemberInfo")
	@ResponseBody
	public Msg addMemberInfo(@Validated(QpGroup.Add.class) MemberInfo memberInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<MemberInfo> list=memberInfoService.getMemberInfoBy(memberInfo);
		if(list.size()!=0){
			return Msg.fail().add("result", "手机号已经注册！");
		}
		memberInfoService.addMemberInfo(memberInfo);
		return Msg.success();
	}
	
	@RequiresPermissions("getMemberInfo")
	@RequestMapping("getMemberInfo")
	@ResponseBody
	public Msg getMemberInfo(HttpServletRequest request){
		String userId=BaseController.getCurrentInfo().get("id");
		return Msg.success().add("result",userId);
	}
	
	/**修改会员信息
	 * @param memberInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("updateMemberInfo")
	@RequestMapping("updateMemberInfo")
	@ResponseBody
	public Msg updateMemberInfo(@Validated(QpGroup.Update.class) MemberInfo memberInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<MemberInfo> list=memberInfoService.getMemberInfoBy(memberInfo);
		if(list.size()!=0){
			return Msg.fail().add("result", "手机号或邮箱已经注册！");
		}
		String userId=BaseController.getCurrentInfo().get("id");
		memberInfo.setId(userId);
		memberInfoService.updateMemberInfo(memberInfo);
		return Msg.success();
	}
}
