package com.qppi.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.CarInfo;
import com.qppi.crud.bean.MemberInfo;
import com.qppi.crud.service.CarInfoService;
import com.qppi.crud.service.ContactsInfoService;
import com.qppi.crud.service.MemberInfoService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("CarInfoController")
public class CarInfoController extends BaseController{

	@Autowired
	private CarInfoService carInfoService;
	@Autowired
	private ContactsInfoService contactsInfoService;
	@Autowired
	private MemberInfoService memberInfoService;
	
	/**
	 * 根据车牌号查询是否存在车信息
	 * @param carInfo
	 * @param result
	 * @return
	 */
	@RequiresPermissions("getCarInfo")
	@RequestMapping("getCarInfo")
	@ResponseBody
	public Msg getCarInfo(@Validated(QpGroup.Get.class) CarInfo carInfo,BindingResult result){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		carInfo=carInfoService.getCarInfo(carInfo);
		if(carInfo==null){
			return Msg.fail().add("result", "不存在车信息");
		}
		List<MemberInfo> memberInfos=memberInfoService.getMemberInfoByCar(carInfo.getId());
		if(memberInfos.size()!=1 ||memberInfos==null){
			return Msg.fail().add("redult", "车关联账号有误！");
		}
		Map<String, Object> map = assemblyParameters(carInfo, memberInfos.get(0));
			return Msg.success().add("result",map);
	}
	
	
	/**
	 * 不存在车信息，新增车信息
	 * @param carInfo
	 * @param result
	 * @return
	 */
	@RequiresPermissions("addCarInfo")
	@RequestMapping("addCarInfo")
	@ResponseBody
	public Msg addCarInfo(@Validated(QpGroup.Add.class) CarInfo carInfo,BindingResult result,
			HttpServletRequest request,@Validated(QpGroup.Get.class)MemberInfo memberInfo,BindingResult result2){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}	
		if(result2.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result2.getFieldErrors()));
		}	
		List<MemberInfo> memberInfos=memberInfoService.getMemberInfoBy(memberInfo);
		if(memberInfos.size()!=1 || memberInfos==null){
			return Msg.fail().add("redult", "手机号有误！");
		}
		CarInfo carInfo2=carInfoService.getCarInfo(carInfo);
		if(carInfo2!=null){
			return Msg.fail().add("result", "该车牌号已存在，请不要重复注册");
		}
		String userId=BaseController.getCurrentInfo().get("id");
			carInfo.setCreateBy(userId);
			carInfo=carInfoService.addCarInfo(carInfo);
			memberInfoService.addMemCarId(memberInfos.get(0),carInfo);
			Map<String, Object> map = assemblyParameters(carInfo,memberInfos.get(0));
				return Msg.success().add("result", map);
	}


	/**组装参数-作为订单表的参数
	 * @param carInfo
	 * @param contactsInfo
	 * @return
	 */
	private Map<String, Object> assemblyParameters(CarInfo carInfo,
			MemberInfo memberInfo) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("carNum", carInfo.getCarnum1());
		map.put("carId", carInfo.getId());
		map.put("memAccount", memberInfo.getMemAccount());
		return map;
	}
}
