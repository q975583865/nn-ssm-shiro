package com.qppi.crud.bean;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class OfferPart {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(message="订单id不能为空",groups={QpGroup.Add.class,QpGroup.Get.class})
    private String orderId;

    private String recheckId;
    @NotBlank(message="报价人不能为空",groups=QpGroup.Add.class)
    private String offerId;
    @NotBlank(message="销售人不能为空",groups=QpGroup.Add.class)
    private String saleId;
    
    private Double total;

    private String remarks;
    
    private List<OfferMx> offerMxs;
    

    public List<OfferMx> getOfferMxs() {
		return offerMxs;
	}

	public void setOfferMxs(List<OfferMx> offerMxs) {
		this.offerMxs = offerMxs;
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

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId == null ? null : offerId.trim();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}