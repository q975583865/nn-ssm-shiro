package com.qppi.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.ArrangeWork;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.service.ArrangeWorkService;
import com.qppi.crud.service.OrderInfoService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("ArrangeWorkController")
public class ArrangeWorkController extends BaseController{

	@Autowired
	private ArrangeWorkService arrangeWorkService;
	@Autowired
	private OrderInfoService orderInfoService;
	
	/**新增派工单和修改订单的技师id
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addArrangeWork")
	@RequestMapping("addArrangeWork")
	@ResponseBody
	public Msg addArrangeWork(@RequestBody@Validated(QpGroup.Add.class) ArrangeWork arrangeWork,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		OrderInfo orderInfo=orderInfoService.getOrderById(arrangeWork.getOrderId(),userId);
		if(orderInfo==null){
			return Msg.fail().add("result", "订单不存在");
		}
		String orderStatus=orderInfo.getOrderState();
		if(!orderStatus.equals(String.valueOf(OrderStatus.HAVECHECKED.getIndex()))){
			return Msg.fail().add("result", "还未复核不能创建派工单");
		}
		String userId1=BaseController.getCurrentInfo().get("id");
		arrangeWork.setCreateBy(userId1);
		arrangeWorkService.addArrangeWork(arrangeWork);
			return	Msg.success();
	}
	
	/**技师查询派工列表
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getArrangeWorkList")
	@RequestMapping("getArrangeWorkList")
	@ResponseBody
	public Msg getArrangeWorkList(HttpServletRequest request){
		String userId=BaseController.getCurrentInfo().get("id");
		return Msg.success().add("result", arrangeWorkService.getArrangeWorkList(userId));
	}
	
	
	/**技师查询派工详情单
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getArrangeWork")
	@RequestMapping("getArrangeWork")
	@ResponseBody
	public Msg getArrangeWork(String arrangeWorkId,HttpServletRequest request){
		if(StringUtils.isBlank(arrangeWorkId)){
			return Msg.fail().add("result", "派工ID不能为空");
		}
		String userId=BaseController.getCurrentInfo().get("id");
		return arrangeWorkService.getArrangeWork(userId,arrangeWorkId);
	}
	
	/**顾问查询派工列表
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getArrangeWorkByService")
	@RequestMapping("getArrangeWorkByService")
	@ResponseBody
	public Msg getArrangeWorkByService(String orderId,HttpServletRequest request){
		if(StringUtils.isBlank(orderId)){
			return Msg.fail().add("result", "orderId不能为空");
		}
		String userId=BaseController.getCurrentInfo().get("id");
		return Msg.success().add("result", arrangeWorkService.getArrangeWorkByService(userId,orderId));
	}
	
	/**顾问查询派工列表
	 * @param arrangeWork
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("getArrangeWorkMxByService")
	@RequestMapping("getArrangeWorkMxByService")
	@ResponseBody
	public Msg getArrangeWorkMxByService(String arrangeWorkId,HttpServletRequest request){
		if(StringUtils.isBlank(arrangeWorkId)){
			return Msg.fail().add("result", "arrangeWorkId不能为空");
		}
		return Msg.success().add("result", arrangeWorkService.getArrangeWorkMxByService(arrangeWorkId));
	}
}
