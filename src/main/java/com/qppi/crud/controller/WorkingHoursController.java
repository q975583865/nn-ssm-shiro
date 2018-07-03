package com.qppi.crud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.ArrangeWork;
import com.qppi.crud.bean.WorkMx;
import com.qppi.crud.bean.WorkingHours;
import com.qppi.crud.service.ArrangeWorkService;
import com.qppi.crud.service.OrderInfoService;
import com.qppi.crud.service.WorkingHoursService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("WorkingHoursController")
public class WorkingHoursController extends BaseController{
	@Autowired
	private WorkingHoursService workingHoursService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private ArrangeWorkService arrangeWorkService;
	
	/**获取作业项目名称
	 * @param workingHours
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping("getWorkingList")
	@ResponseBody
	public Msg getWorkingList(@Validated(QpGroup.Add.class)WorkingHours workingHours,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		List<List<WorkMx>> workMxs=new ArrayList<>();
		
		String userId=BaseController.getCurrentInfo().get("id");
		List<ArrangeWork> listArrangeWorks=arrangeWorkService.getArrangeWorkByService(userId,workingHours.getOrderId());
		for(ArrangeWork arrangeWork:listArrangeWorks){
			workMxs.add(arrangeWorkService.getArrangeWorkMxByService(arrangeWork.getId()));
		}
		return  Msg.success().add("result", workMxs);
	}
	
	/**创建工时结算表
	 * @param workingHours
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addWorkingHours")
	@RequestMapping("addWorkingHours")
	@ResponseBody
	public Msg addWorkingHours(@RequestBody@Validated(QpGroup.Add.class)WorkingHours workingHours,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		workingHours.setCreateBy(userId);
		Boolean isComplete=orderInfoService.compareStatus(workingHours);
		if(!isComplete){
			return Msg.fail().add("result", "该订单状态异常或找不到该订单！");
		}
		
		workingHoursService.addWorkingHours(workingHours);
		return Msg.success();
	}
	
}
