package com.qppi.crud.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qppi.crud.Enum.OrderStatus;
import com.qppi.crud.bean.OrderInfo;
import com.qppi.crud.bean.PartBuy;
import com.qppi.crud.bean.PartBuyMx;
import com.qppi.crud.bean.RepoChange;
import com.qppi.crud.bean.RepoIn;
import com.qppi.crud.bean.RepoInfo;
import com.qppi.crud.bean.RepoInfoExample;
import com.qppi.crud.bean.RepoInfoPart;
import com.qppi.crud.bean.RepoOut;
import com.qppi.crud.controller.BaseController;
import com.qppi.crud.dao.OrderInfoMapper;
import com.qppi.crud.dao.PartBuyMapper;
import com.qppi.crud.dao.PartBuyMxMapper;
import com.qppi.crud.dao.RepoChangeMapper;
import com.qppi.crud.dao.RepoInMapper;
import com.qppi.crud.dao.RepoInfoMapper;
import com.qppi.crud.dao.RepoOutMapper;
import com.qppi.crud.utils.Msg;

@Service
public class RepoInfoService {
	@Autowired
	private RepoInfoMapper repoInfoMapper;
	@Autowired
	private RepoInMapper repoInMapper;
	@Autowired
	private RepoOutMapper repoOutMapper;
	@Autowired
	private RepoChangeMapper repoChangeMapper;
	@Autowired
	private PartBuyMapper partBuyMapper;
	@Autowired
	private PartBuyMxMapper partBuyMxMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;

	public PageInfo<RepoInfo> getRepoInfo(RepoInfo repoInfo,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		RepoInfoExample example=new RepoInfoExample();
		RepoInfoExample.Criteria criteria=example.createCriteria();
		if(StringUtils.isNotBlank(repoInfo.getName())){
			criteria.andNameEqualTo(repoInfo.getName());
		}
		if(StringUtils.isNotBlank(repoInfo.getRepo())){
			criteria.andRepoEqualTo(repoInfo.getRepo());
		}
		if(repoInfo.getCount()!=null){
			criteria.andCountGreaterThan(repoInfo.getCount());
		}
		
		return new PageInfo<RepoInfo>(repoInfoMapper.selectByExample(example));
	}

	public Msg addRepoIn(RepoIn repoIn) {
		RepoInfo repoInfo=repoInfoMapper.selectByPrimaryKey(repoIn.getRepoId());
		if(repoInfo==null || repoInfo.equals("")){
			return Msg.fail().add("result", "仓库不存在该零件！，请联系管理员添加！");
		}
		repoIn.setId(BaseController.uuid());
		repoIn.setCreateDate(new Date());
		repoInMapper.insertSelective(repoIn);
		
		repoInfo.setCount(repoInfo.getCount()+repoIn.getCountIn());
		repoInfoMapper.updateByPrimaryKeySelective(repoInfo);
		return Msg.success();
	}

	public Msg addRepoOut(RepoOut repoOut) {
		RepoInfo repoInfo=repoInfoMapper.selectByPrimaryKey(repoOut.getRepoId());
		if(repoInfo==null || repoInfo.equals("")){
			return Msg.fail().add("result", "仓库不存在该零件！，请联系管理员添加！");
		}
		if(repoInfo.getCount()<repoOut.getCountOut()){
			return Msg.fail().add("result", "仓库零件数量不足，出库失败！");
		}
		repoOut.setId(BaseController.uuid());
		repoOut.setCreateDate(new Date());
		repoOutMapper.insertSelective(repoOut);
		
		repoInfo.setCount(repoInfo.getCount()-repoOut.getCountOut());
		repoInfoMapper.updateByPrimaryKeySelective(repoInfo);
		return Msg.success();
	}

	public Msg addRepoChange(RepoChange repoChange) { 
		RepoInfo repoInfo=repoInfoMapper.selectByPrimaryKey(repoChange.getRepoId());
		RepoInfo repoInfo2=repoInfoMapper.selectByPrimaryKey(repoChange.getRepoChangeId());
		if(repoInfo==null || repoInfo.equals("")){
			return Msg.fail().add("result", "仓库不存在该零件！，请联系管理员添加！");
		}
		if(repoInfo2==null || repoInfo2.equals("")){
			return Msg.fail().add("result", "目标仓库不存在！");
		}
		if(repoInfo.getCount()<repoChange.getChangeCount()){
			return Msg.fail().add("result", "仓库零件数量不足，出库失败！");
		}
		if(repoInfo.getRepo().equals(repoInfo2.getRepo())){
			return Msg.fail().add("result", "目标仓库与原仓库不能一致！");
		}
		repoChange.setId(BaseController.uuid());
		repoChange.setCreateDate(new Date());
		repoChangeMapper.insertSelective(repoChange);
		
		repoInfo.setCount(repoInfo.getCount()-repoChange.getChangeCount());
		repoInfoMapper.updateByPrimaryKeySelective(repoInfo);
		
		repoInfo2.setCount(repoInfo2.getCount()+repoChange.getChangeCount());
		repoInfoMapper.updateByPrimaryKeySelective(repoInfo2);
		
		return Msg.success();
	}


	public List<RepoInfoPart> getRepoInfos(String num) {
		return repoInfoMapper.getRepoInfos(num);
	}

	public Object addPartBuy(PartBuy partBuy) {
		partBuy.setCreateDate(new Date());
		partBuy.setId(BaseController.uuid());
		partBuyMapper.insertSelective(partBuy);
		
		for(PartBuyMx partBuyMx :partBuy.getPartBuyMxs()){
			partBuyMx.setId(BaseController.uuid());
			partBuyMx.setPartBuyId(partBuy.getId());
			partBuyMxMapper.insertSelective(partBuyMx);
		}
		
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(partBuy.getOrderId());
		orderInfo.setOrderState(OrderStatus.BUYINGPARTS.toString());
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
		return null;
	}

	public Object partBuyComplete(String id) {
		OrderInfo orderInfo=new OrderInfo();
		orderInfo.setId(id);
		orderInfo.setOrderState(OrderStatus.HAVECHECKED.toString());
		orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
		return null;
	}

}
