package com.demo.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
//import com.bkzy.cms.common.ApiModelProperty;

public class CfgUser {
    /**
    
     */
//    @ApiModelProperty(value = "")
    private Integer id;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String userId;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String password;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String userName;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String userRemark;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String companyId;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String dept;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String position;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String positionDesc;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String sex;

    /**
    
     */
    @JSONField (format="yyyy-MM-dd")
//    @ApiModelProperty(value = "")
    private Date birthday;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String officePhone;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String mobile;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String homePhone;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String email;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String qq;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String weixin;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String creater;

    /**
    
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "")
    private Date createTime;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private Integer valid;

    /**
    有效时间是以天为单位
     */
//    @ApiModelProperty(value = "有效时间是以天为单位")
    private Integer validtime;

    /**
    
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty(value = "")
    private Date changeTime;

    /**
    
     */
//    @ApiModelProperty(value = "")
    private String changePerson;

    /**
    0-100,过期一天减1
     */
//    @ApiModelProperty(value = "0-100,过期一天减1")
    private Integer roleValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc == null ? null : positionDesc.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getValidtime() {
        return validtime;
    }

    public void setValidtime(Integer validtime) {
        this.validtime = validtime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangePerson() {
        return changePerson;
    }

    public void setChangePerson(String changePerson) {
        this.changePerson = changePerson == null ? null : changePerson.trim();
    }

    public Integer getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(Integer roleValue) {
        this.roleValue = roleValue;
    }
}