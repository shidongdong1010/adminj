package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户简介表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDetail implements Serializable {

    /** 用户ID,自增序列 **/
    private Long userId;

    /** 昵称 **/
    private String nickName;

    /** 性别(M-男,F-女,S-保密) **/
    private String sex;

    /** 年龄 **/
    private String age;

    /** 头像位置 **/
    private String headImgPath;

    /** 公司职务 **/
    private String companyDuties;

    /** 所在城市code **/
    private String cityCode;

    /** 所在城市 **/
    private String cityName;

    /** 所在省份代码 **/
    private String provinceCode;

    /** 所在省份名称 **/
    private String provinceName;

    /** 个人简介 **/
    private String resume;

    /** 个性签名 **/
    private String signature;

    /** 创建日期 **/
    private Date createDate;

    /** 更新日期 **/
    private Date updateDate;

    /** 是否完善资料(Y-是,N-否) **/
    private String isPerfectData;

    public UserDetail() {
        super();
    }

    public UserDetail(Long userId) {
        super();
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeadImgPath() {
        return headImgPath;
    }

    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath;
    }

    public String getCompanyDuties() {
        return companyDuties;
    }

    public void setCompanyDuties(String companyDuties) {
        this.companyDuties = companyDuties;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getIsPerfectData() {
        return isPerfectData;
    }

    public void setIsPerfectData(String isPerfectData) {
        this.isPerfectData = isPerfectData;
    }

}
