package com.qppi.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.service.ContactsInfoService;
import com.qppi.crud.service.OrderInfoService;
import com.qppi.crud.service.ReceptionService;
import com.qppi.crud.service.WorkingHoursService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("OrderInfoController")
public class OrderInfoController extends BaseController{

	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private WorkingHoursService workingHoursService;
	@Autowired
	private ContactsInfoService contactsInfoService;
	@Autowired
	private ReceptionService receptionService;
	
	/**创建订单
	 * @param orderInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addOrderInfo")
	@RequestMapping("addOrderInfo")
	@ResponseBody
	public Msg addOrderInfo(@Validated(QpGroup.Add.class) OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		orderInfo.setCreateBy(userId);
		 orderInfoService.addOrderInfo(orderInfo);
		return Msg.success().add("result", orderInfo);
	}
	
	/**用户查询订单
	 * @param orderInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getOrderByMember")
	@RequestMapping("getOrderByMember")
	@ResponseBody
	public Msg getOrderByMember(OrderInfo orderInfo,HttpServletRequest request){
		String memAccount=BaseController.getCurrentInfo().get("username");
		return Msg.success().add("result", orderInfoService.getOrderByMemAccount(memAccount,orderInfo));
	}
	
	/**服务顾问查询订单列表
	 * @param orderInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getOrdersByService")
	@RequestMapping("getOrdersByService")
	@ResponseBody
	public Msg getOrdersByService(OrderInfo orderInfo,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize,HttpServletRequest request){
		String userId=BaseController.getCurrentInfo().get("id");
		return Msg.success().add("result", orderInfoService.getOrdersByService(orderInfo,userId,pageNum,pageSize));
	}
	
	/**服务顾问查询订单详情
	 * @param orderInfo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getOrderDetailByService")
	@RequestMapping("getOrderDetailByService")
	@ResponseBody
	public Msg getOrderDetailByService(OrderInfo orderInfo,
			HttpServletRequest request){
		if(StringUtils.isBlank(orderInfo.getId())){
			return Msg.fail().add("result", "订单id不能为空！");
		}
		String userId=BaseController.getCurrentInfo().get("id");
		return orderInfoService.getOrderDetailByService(orderInfo,userId);
	}
	
	/**系统查询订单--应该不要这个功能
	 * @param orderInfo
	 * @return
	 */
/*	@RequestMapping("getOrderBystatus")
	@ResponseBody
	public Msg getOrderBystatus(OrderInfo orderInfo){
		return Msg.success().add("result", orderInfoService.getOrderBystatus(orderInfo));
	}*/
	
	/**技师查询订单
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getOrderByWorker")
	@RequestMapping("getOrderByWorker")
	@ResponseBody
	public Msg getOrderByWorker(OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		return	Msg.success().add("result", orderInfoService.getOrderByWorker(userId,orderInfo));
	}
	
	/**
	 * 技师确认开工按钮
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("updateWorkStatusConfirm")
	@RequestMapping("updateWorkStatusConfirm")
	@ResponseBody
	public Msg updateWorkStatusConfirm(@Validated(QpGroup.Update.class) OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		return orderInfoService.updateWorkStatusConfirm(userId,orderInfo);
	}
	
	
	/**是否需要零配件按钮
	 * @param ifNeedParts 是否需要配件 1需要
	 * @param orderId 订单id
	 * @return
	 */
	@RequiresPermissions("ifNeedParts")
	@RequestMapping("ifNeedParts")
	@ResponseBody
	public Msg ifNeedParts(String ifNeedParts,String orderId,HttpServletRequest request){
		if(StringUtils.isBlank(ifNeedParts)){
			return Msg.fail().add("result", "ifNeedParts参数不能为空");
		}
		if(StringUtils.isBlank(orderId)){
			return Msg.fail().add("result", "订单id不能为空");
		}
		return orderInfoService.ifNeedParts(orderId,ifNeedParts);
	}
	
	/**是否同意修车
	 * @param isAgreeRepair 1同意
	 * @param orderId
	 * @param request
	 * @return
	 */
	@RequiresPermissions("isAgreeRepair")
	@RequestMapping("isAgreeRepair")
	@ResponseBody
	public Msg isAgreeRepair(String isAgreeRepair,String orderId,HttpServletRequest request){
		if(StringUtils.isBlank(isAgreeRepair)){
			return Msg.fail().add("result", "isAgreeRepair参数不能为空");
		}
		if(StringUtils.isBlank(orderId)){
			return Msg.fail().add("result", "订单id不能为空");
		}
		String memberTel= BaseController.getCurrentInfo().get("username");
		return orderInfoService.isAgreeRepair(orderId,isAgreeRepair,memberTel);
	}
	
	/**
	 * 技师修好了按钮
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("updateWorkStatusCompletion")
	@RequestMapping("updateWorkStatusCompletion")
	@ResponseBody
	public Msg updateWorkStatusCompletion(@Validated(QpGroup.Update.class) OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		orderInfoService.updateWorkStatusCompletion(orderInfo);
		return Msg.success(); 
	}
	
	
	
	
	/**用户同意修车
	 * @param reception
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping("agreeOrderInfo")
	@ResponseBody
	public Msg agreeOrderInfo(@Validated(QpGroup.UpdateAuth.class) OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		
		String phone=BaseController.getCurrentInfo().get("username");
		 orderInfo  =orderInfoService.getOrderByIdAndPhone(orderInfo.getId(),phone);
		if(orderInfo==null){
			return Msg.fail().add("result", "订单不存在");
		}
		if(!orderInfo.getOrderState().equals("9")){
			return Msg.fail().add("result", "订单状态异常");
		}
		orderInfoService.updateWorkStatusAgree(orderInfo);
			return Msg.success();	
	}
	
	/**用户不同意修车
	 * @param reception
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping("notAgreeOrderInfo")
	@ResponseBody
	public Msg notAgreeOrderInfo(@Validated(QpGroup.UpdateAuth.class) OrderInfo orderInfo,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String phone=BaseController.getCurrentInfo().get("username");
		 orderInfo  =orderInfoService.getOrderByIdAndPhone(orderInfo.getId(),phone);
		if(orderInfo==null){
			return Msg.fail().add("result", "订单不存在");
		}
		if(!orderInfo.getOrderState().equals("9")){
			return Msg.fail().add("result", "订单状态异常");
		}
		orderInfoService.updateWorkStatusNotAgree(orderInfo);
			return Msg.success();	
	}

}
