package com.qppi.crud.bean;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qppi.crud.utils.QpGroup;

public class Reception {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(message="订单id不能为空",groups={QpGroup.Add.class,QpGroup.Update.class,QpGroup.UpdateAuth.class})
    private String orderId;

    private String serId;
    @NotBlank(message="里程数不能为空",groups=QpGroup.Add.class)
    private String carLc;

    private String recheckId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past (message="入厂时间不能为空",groups=QpGroup.Add.class)
    private Date timeIn;
    @NotBlank(message="路试检测不能为空",groups=QpGroup.UpdateAuth.class)
    private String isAgree;
    @NotBlank(message="授权凭证不能为空",groups=QpGroup.UpdateAuth.class)
    private String memInfo;

    private String remarks;

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

    public String getSerId() {
        return serId;
    }

    public void setSerId(String serId) {
        this.serId = serId == null ? null : serId.trim();
    }

    public String getCarLc() {
        return carLc;
    }

    public void setCarLc(String carLc) {
        this.carLc = carLc == null ? null : carLc.trim();
    }

    public String getRecheckId() {
        return recheckId;
    }

    public void setRecheckId(String recheckId) {
        this.recheckId = recheckId == null ? null : recheckId.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree == null ? null : isAgree.trim();
    }

    public String getMemInfo() {
        return memInfo;
    }

    public void setMemInfo(String memInfo) {
        this.memInfo = memInfo == null ? null : memInfo.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}