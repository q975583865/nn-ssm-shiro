package com.qppi.crud.bean;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class WorkingHours {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(message="订单id不能为空",groups={QpGroup.Add.class,QpGroup.Update.class})
    private String orderId;
    
    private Date payTime;
    
    private Date timeOut;
    
    private Double total;

    private String remarkPay;

    private String remarks;
    
    private List<HoursMx> hoursMxs;
    
    
    public List<HoursMx> getHoursMxs() {
		return hoursMxs;
	}

	public void setHoursMxs(List<HoursMx> hoursMxs) {
		this.hoursMxs = hoursMxs;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRemarkPay() {
        return remarkPay;
    }

    public void setRemarkPay(String remarkPay) {
        this.remarkPay = remarkPay == null ? null : remarkPay.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}