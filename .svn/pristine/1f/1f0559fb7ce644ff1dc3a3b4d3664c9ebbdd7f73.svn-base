package com.qppi.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.Reception;
import com.qppi.crud.service.OrderInfoService;
import com.qppi.crud.service.ReceptionService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("ReceptionController")
public class ReceptionController extends BaseController{
	@Autowired
	private ReceptionService receptionService;
	@Autowired
	private OrderInfoService orderInfoService;
	
	/**创建接车表
	 * @param reception
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addReception")
	@RequestMapping("addReception")
	@ResponseBody
	public Msg addReception(@Validated(QpGroup.Add.class) Reception reception,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		reception.setCreateBy(userId);
		receptionService.addReception(reception);
		return Msg.success();
	}
	
	/**用户授权
	 * @param reception
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("authOrderInfo")
	@RequestMapping("authOrderInfo")
	@ResponseBody
	public Msg authOrderInfo(@Validated(QpGroup.UpdateAuth.class) Reception reception,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String phone=BaseController.getCurrentInfo().get("username");
		OrderInfo orderInfo  =orderInfoService.getOrderByIdAndPhone(reception.getOrderId(),phone);
		if(orderInfo==null){
			return Msg.fail().add("result", "订单已授权！");
		}
		
		 receptionService.authOrderInfo(reception);
			return Msg.success();	
	}
	
	/** 系统复核
	 * @param reception
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("checkOrderInfo")
	@RequestMapping("checkOrderInfo")
	@ResponseBody
	public Msg checkOrderInfo(@Validated(QpGroup.Update.class) Reception reception,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		OrderInfo orderInfo=orderInfoService.getOrder(reception.getOrderId());
		if(orderInfo==null){
			return Msg.fail().add("result", "订单不存在常");
		}
		if(!orderInfo.getOrderState().equals(OrderStatus.HAVEAUTH.toString())){
			return Msg.fail().add("result", "订单状态异常");
		}
		String userId=BaseController.getCurrentInfo().get("id");
		reception.setRecheckId(userId);
		receptionService.checkOrderInfo(reception);
	
			return Msg.success();
		
	}
}
