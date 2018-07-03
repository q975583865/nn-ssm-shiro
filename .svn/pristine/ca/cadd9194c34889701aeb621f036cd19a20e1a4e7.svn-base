package com.qppi.crud.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qppi.crud.bean.InfoRelay;
import com.qppi.crud.service.InfoRelayService;
import com.qppi.crud.utils.FieldErrorUtil;
import com.qppi.crud.utils.Msg;
import com.qppi.crud.utils.MultipartFileUtils;
import com.qppi.crud.utils.QpGroup;

@Controller
@RequestMapping("InfoRelayController")
public class InfoRelayController extends BaseController{
	@Autowired
	private InfoRelayService infoRelayService;
	
	/**故障反馈单
	 * @return
	 */
	@RequestMapping("failureInfoRelay")
	@ResponseBody
	public Msg failureInfoRelay(@Validated(QpGroup.Add.class)InfoRelay infoRelay,BindingResult result,
			HttpServletRequest request,@RequestParam(value = "InfoRelayFile", required = false) MultipartFile InfoRelayFile){
		if(result.hasErrors()){
			return Msg.fail().add("result", FieldErrorUtil.error(result.getFieldErrors()));
		}
		if(InfoRelayFile!=null){
			Map<String, Object> map=MultipartFileUtils.saveFile(request, InfoRelayFile, MultipartFileUtils.INFORELAYFILE_SAVE_PATH);
			if(!map.get("code").equals("0000")){
				return Msg.fail().add("result", map.get("msg"));
			}
			infoRelay.setRelayFile(map.get("msg").toString());
		}
		String userId=BaseController.getCurrentInfo().get("id");
		infoRelay.setCreateBy(userId);
		infoRelayService.failureInfoRelay(infoRelay);
		return Msg.success();
	}
}
