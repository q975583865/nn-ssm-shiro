package com.qppi.crud.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qppi.crud.bean.SysUser;
import com.qppi.crud.service.SysUserService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.MultipartFileUtils;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("SysUserController")
public class SysUserController extends BaseController{
	@Autowired
	private SysUserService sysUserService;
	
	/**服务顾问注册
	 * @param sysUser
	 * @param result
	 * @param request
	 * @param photo
	 * @return
	 */
	@RequestMapping("addSysUserService")
	@ResponseBody
	public Msg addSysUserService(@Validated(QpGroup.Add.class) SysUser sysUser,BindingResult result,
			HttpServletRequest request,@RequestParam(value = "photoImg", required = false) MultipartFile photoImg){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<SysUser> list=sysUserService.selectByPhoneOrEamil(sysUser);
		if(list.size()>0){
			return Msg.fail().add("result", "手机号已被注册！");
		}
		
		if(photoImg!=null){
			Map<String, Object> map=MultipartFileUtils.saveFile(request, photoImg, MultipartFileUtils.SERVICEPHOTO_SAVE_PATH);
			if(!map.get("code").equals("0000")){
				return Msg.fail().add("result", map.get("msg"));
			}
			sysUser.setPhoto(map.get("msg").toString());
		}
		
		sysUserService.addSysUserService(sysUser);
		return Msg.success();
	}
	
	/**技师注册
	 * @param sysUser
	 * @param result
	 * @param request
	 * @param photo
	 * @return
	 */
	@RequestMapping("addSysUserWork")
	@ResponseBody
	public Msg addSysUserWork(@Validated(QpGroup.Add.class) SysUser sysUser,BindingResult result,
			HttpServletRequest request,@RequestParam(value = "photoImg", required = false) MultipartFile photoImg){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<SysUser> list=sysUserService.selectByPhoneOrEamil(sysUser);
		if(list.size()>0){
			return Msg.fail().add("result", "手机号已被注册！");
		}
		
		if(photoImg!=null){
			Map<String, Object> map=MultipartFileUtils.saveFile(request, photoImg, MultipartFileUtils.WORKPHOTO_SAVE_PATH);
			if(!map.get("code").equals("0000")){
				return Msg.fail().add("result", map.get("msg"));
			}
			sysUser.setPhoto(map.get("msg").toString());
		}
		
		sysUserService.addSysUserWork(sysUser);
		return Msg.success();
	}
	
	/**查詢技師列表
	 * @return
	 */
	@RequestMapping("getWorkerList")
	@ResponseBody
	public Msg getWorkerList(){
		return sysUserService.getWorkerList();
	}
	
	/**新增系统管理员
	 * @param sysUser
	 * @param result
	 * @param request
	 * @param photoImg
	 * @return
	 */
	@RequiresPermissions("addSysUserManage")
	@RequestMapping("addSysUserManage")
	@ResponseBody
	public Msg addSysUserManage(@Validated(QpGroup.Add.class) SysUser sysUser,BindingResult result,
			HttpServletRequest request,@RequestParam(value = "photoImg", required = false) MultipartFile photoImg){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<SysUser> list=sysUserService.selectByPhoneOrEamil(sysUser);
		if(list.size()>0){
			return Msg.fail().add("result", "手机号已被注册！");
		}
		
		if(photoImg!=null){
			Map<String, Object> map=MultipartFileUtils.saveFile(request, photoImg, MultipartFileUtils.WORKPHOTO_SAVE_PATH);
			if(!map.get("code").equals("0000")){
				return Msg.fail().add("result", map.get("msg"));
			}
			sysUser.setPhoto(map.get("msg").toString());
		}
		
		sysUserService.addSysUserManage(sysUser);
		return Msg.success();
	}
}
