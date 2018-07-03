package com.qppi.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.OfferMx;
import com.qppi.crud.bean.OfferPart;
import com.qppi.crud.service.OfferPartService;
import com.qppi.crud.service.OrderInfoService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@RequestMapping("OfferPartController")
@Controller
public class OfferPartController extends BaseController{
	@Autowired
	private OfferPartService offerPartService;
	@Autowired
	private OrderInfoService orderInfoService;
	
	
	/**新建配件报价表
	 * @param offerPart
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addOfferPart")
	@RequestMapping("addOfferPart")
	@ResponseBody
	public Msg addOfferPart(@RequestBody@Validated(QpGroup.Add.class) OfferPart offerPart,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		offerPart.setCreateBy(userId);
		return  offerPartService.addOfferPart(offerPart);
	}
	
	/**根据订单id查询报价单
	 * @return
	 */
	@RequestMapping("getOfferPartByOrder")
	@ResponseBody
	public Msg getOfferPartByOrder(@Validated(QpGroup.Get.class) OfferPart offerPart,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		return Msg.success().add("result", offerPartService.getOfferPartByOrder(offerPart));
	}
	
	/**查询报价详情表
	 * @return
	 */
	@RequestMapping("getOfferPartDetail")
	@ResponseBody
	public Msg getOfferPartDetail(@Validated(QpGroup.Get.class) OfferMx offerMx,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		return Msg.success().add("result", offerPartService.getOfferPartDetail(offerMx));
	}
	
}
