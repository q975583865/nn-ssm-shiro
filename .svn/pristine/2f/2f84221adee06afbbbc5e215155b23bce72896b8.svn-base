package com.qppi.crud.bean;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qppi.crud.utils.QpGroup;

public class ArrangeWork {
	@NotBlank(message="派工id不能为空",groups=QpGroup.Get.class)
    private String id;

    private String createBy;
    
    
    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(message="订单号不能为空",groups=QpGroup.Add.class)
    private String orderId;

    private String recheckId;
    @NotBlank(message="维修技师id不能为空",groups=QpGroup.Add.class)
    private String workId;
    
    private String dateReback;

    private String checkFull;

    private String remarkCheckFull;

    private String remarks;
    
    private List<WorkMx> workMxs;
    

    public List<WorkMx> getWorkMxs() {
		return workMxs;
	}

	public void setWorkMxs(List<WorkMx> workMxs) {
		this.workMxs = workMxs;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }


    
    public String getDateReback() {
		return dateReback;
	}

	public void setDateReback(String dateReback) {
		this.dateReback = dateReback;
	}

	public String getCheckFull() {
        return checkFull;
    }

    public void setCheckFull(String checkFull) {
        this.checkFull = checkFull == null ? null : checkFull.trim();
    }

    public String getRemarkCheckFull() {
        return remarkCheckFull;
    }

    public void setRemarkCheckFull(String remarkCheckFull) {
        this.remarkCheckFull = remarkCheckFull == null ? null : remarkCheckFull.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}