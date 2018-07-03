package com.qppi.crud.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.qppi.crud.utils.QpGroup;

public class MemberInfo {
    private String id;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;
    @NotBlank(groups={QpGroup.Get.class,QpGroup.Add.class,QpGroup.Login.class},message="用户手机号不能为空")
    private String memAccount;
    @NotBlank(groups={QpGroup.Add.class,QpGroup.Login.class},message="用户密码不能为空")
    private String memPassword;

    private String memName;

    private String memSex;

    private String memNum;

    private String memAddr;

    private String memEmail;
    
    private String memTel;

    private String remarks;

    private String carId;

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

    public String getMemAccount() {
        return memAccount;
    }

    public void setMemAccount(String memAccount) {
        this.memAccount = memAccount == null ? null : memAccount.trim();
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword == null ? null : memPassword.trim();
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName == null ? null : memName.trim();
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex == null ? null : memSex.trim();
    }

    public String getMemNum() {
        return memNum;
    }

    public void setMemNum(String memNum) {
        this.memNum = memNum == null ? null : memNum.trim();
    }

    public String getMemAddr() {
        return memAddr;
    }

    public void setMemAddr(String memAddr) {
        this.memAddr = memAddr == null ? null : memAddr.trim();
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail == null ? null : memEmail.trim();
    }

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel == null ? null : memTel.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }
}