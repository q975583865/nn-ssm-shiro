package com.qppi.crud.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qppi.crud.utils.QpGroup;

public class PartBuy {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(message="不能为空",groups=QpGroup.Add.class)
    private String orderId;

    private String recheckId;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date relayDate;

    private String remarks;
    
    private List<PartBuyMx> partBuyMxs;
    
    

    public List<PartBuyMx> getPartBuyMxs() {
		return partBuyMxs;
	}

	public void setPartBuyMxs(List<PartBuyMx> partBuyMxs) {
		this.partBuyMxs = partBuyMxs;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getRecheckId() {
        return recheckId;
    }

    public void setRecheckId(String recheckId) {
        this.recheckId = recheckId == null ? null : recheckId.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getRelayDate() {
        return relayDate;
    }

    public void setRelayDate(Date relayDate) {
        this.relayDate = relayDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}