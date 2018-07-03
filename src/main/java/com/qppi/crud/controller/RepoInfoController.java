package com.qppi.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.PartBuy;
import com.qppi.crud.bean.RepoChange;
import com.qppi.crud.bean.RepoIn;
import com.qppi.crud.bean.RepoInfo;
import com.qppi.crud.bean.RepoOut;
import com.qppi.crud.service.RepoInfoService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.QpGroup;

@RequestMapping("RepoInfoController")
@Controller
public class RepoInfoController extends BaseController{
	@Autowired
	private RepoInfoService repoInfoService;
	
	@RequestMapping("getRepoInfo")
	@ResponseBody
	public Msg getRepoInfo(RepoInfo repoInfo,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize ){
		return Msg.success().add("result", repoInfoService.getRepoInfo(repoInfo,pageNum,pageSize));
	}
	
	
	@RequestMapping("addRepoIn")
	@ResponseBody
	public Msg addRepoIn(@Validated(QpGroup.Add.class)RepoIn repoIn,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		repoIn.setCreateBy(userId);
		return repoInfoService.addRepoIn(repoIn);
	}
	
	@RequestMapping("addRepoOut")
	@ResponseBody
	public Msg addRepoOut(@Validated(QpGroup.Add.class)RepoOut repoOut,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		repoOut.setCreateBy(userId);
		return repoInfoService.addRepoOut(repoOut);
	}
	
	@RequestMapping("addRepoChange")
	@ResponseBody
	public Msg addRepoChange(@Validated(QpGroup.Add.class)RepoChange repoChange,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		repoChange.setCreateBy(userId);
		return repoInfoService.addRepoChange(repoChange);
	}
	
	
	/** 查询配件列表及信息
	 * @param num
	 * @return
	 */
	@RequestMapping("getRepoInfos")
	@ResponseBody
	public Msg getRepoInfos(@RequestParam String num){
		return Msg.success().add("result",repoInfoService.getRepoInfos(num));
	}
	
	/**新增零配件采购表
	 * @param partBuy
	 * @param result
	 * @param request
	 * @return
	 */
	@RequiresPermissions("addPartBuy")
	@RequestMapping("addPartBuy")
	@ResponseBody
	public Msg addPartBuy(@RequestBody@Validated(QpGroup.Add.class)PartBuy partBuy,BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		String userId=BaseController.getCurrentInfo().get("id");
		partBuy.setCreateBy(userId);
		return Msg.success().add("result",repoInfoService.addPartBuy(partBuy));
	}
	
	/**采购完毕
	 * @param orderInfo
	 * @param result
	 * @return
	 */
	@RequiresPermissions("partBuyComplete")
	@RequestMapping("partBuyComplete")
	@ResponseBody
	public Msg partBuyComplete(@Validated(QpGroup.Update.class)OrderInfo orderInfo,BindingResult result){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		return Msg.success().add("result",repoInfoService.partBuyComplete(orderInfo.getId()));
	}
}
