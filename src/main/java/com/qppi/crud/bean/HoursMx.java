package com.qppi.crud.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class HoursMx {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;

    private String hoursId;

    private Integer no;
    @NotBlank(message="作业项目名称不能为空",groups=QpGroup.Add.class)
    private String name;
    @NotBlank(message="金额不能为空",groups=QpGroup.Add.class)
    private String price;

    private Double priceE;
    @NotBlank(message="折扣率不能为空",groups=QpGroup.Add.class)
    private String xkl;
    
    private Double priceS;

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

    public String getHoursId() {
        return hoursId;
    }

    public void setHoursId(String hoursId) {
        this.hoursId = hoursId == null ? null : hoursId.trim();
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Double getPriceE() {
        return priceE;
    }

    public void setPriceE(Double priceE) {
        this.priceE = priceE;
    }

    public String getXkl() {
        return xkl;
    }

    public void setXkl(String xkl) {
        this.xkl = xkl == null ? null : xkl.trim();
    }

    public Double getPriceS() {
        return priceS;
    }

    public void setPriceS(Double priceS) {
        this.priceS = priceS;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}