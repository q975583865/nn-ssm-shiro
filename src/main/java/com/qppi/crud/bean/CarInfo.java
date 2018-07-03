package com.qppi.crud.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class CarInfo extends CarInfoKey {
    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    
    @NotBlank(message="车牌号不能为空",groups={QpGroup.Get.class,QpGroup.Add.class})
    private String carnum1;
    @NotBlank(message="车架号不能为空",groups=QpGroup.Add.class)
    private String carnum2;
    @NotBlank(message="发动机号不能为空",groups=QpGroup.Add.class)
    private String carnum3;
    @NotBlank(message="汽车品牌不能为空",groups=QpGroup.Add.class)
    private String carbrand;
    @NotBlank(message="车外颜色不能为空",groups=QpGroup.Add.class)
    private String carcolorout;
    @NotBlank(message="车内颜色不能为空",groups=QpGroup.Add.class)
    private String carcolorin;
    @NotBlank(message="汽车车型不能为空",groups=QpGroup.Add.class)
    private String cartype;

    private String remarks;
    
    

    public String getCarnum1() {
		return carnum1;
	}

	public void setCarnum1(String carnum1) {
		this.carnum1 = carnum1;
	}
	
	

	public String getCarnum2() {
		return carnum2;
	}

	public void setCarnum2(String carnum2) {
		this.carnum2 = carnum2;
	}

	public String getCarnum3() {
		return carnum3;
	}

	public void setCarnum3(String carnum3) {
		this.carnum3 = carnum3;
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

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand == null ? null : carbrand.trim();
    }

    public String getCarcolorout() {
        return carcolorout;
    }

    public void setCarcolorout(String carcolorout) {
        this.carcolorout = carcolorout == null ? null : carcolorout.trim();
    }

    public String getCarcolorin() {
        return carcolorin;
    }

    public void setCarcolorin(String carcolorin) {
        this.carcolorin = carcolorin == null ? null : carcolorin.trim();
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}