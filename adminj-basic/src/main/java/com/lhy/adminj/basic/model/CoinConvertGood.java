package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 兑换商品表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertGood implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 商品名称 **/
    private String name;

    /** 开始时间 **/
    private Date beginTime;

    /** 结束时间 **/
    private Date endTime;

    /** 金币 **/
    private Double coin;

    /** 金额 **/
    private Double amount;

    /** 数量 **/
    private Long num;

    /** 每日数量 **/
    private Long dayNum;

    /** 是否收货地址(0-否,1-是) **/
    private Long isAddr;

    /** 商品简介 **/
    private String summary;

    /** 使用说明 **/
    private String useDesc;

    /** 兑换说明 **/
    private String convertDesc;

    /** 是否启用(0-启用,1-下架) **/
    private Long isEnable;

    /** 发布时间 **/
    private Date publishTime;

    /** 发布用户ID **/
    private Long publishUserId;

    /** 修改时间 **/
    private Date modifyTime;

    /** 修改用户ID **/
    private Long modifyUserId;

    /** 小图片路径 **/
    private String minPicPath;

    /** 大图片路径 **/
    private String maxPicPath;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getCoin() {
        return coin;
    }

    public void setCoin(Double coin) {
        this.coin = coin;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getDayNum() {
        return dayNum;
    }

    public void setDayNum(Long dayNum) {
        this.dayNum = dayNum;
    }

    public Long getIsAddr() {
        return isAddr;
    }

    public void setIsAddr(Long isAddr) {
        this.isAddr = isAddr;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUseDesc() {
        return useDesc;
    }

    public void setUseDesc(String useDesc) {
        this.useDesc = useDesc;
    }

    public String getConvertDesc() {
        return convertDesc;
    }

    public void setConvertDesc(String convertDesc) {
        this.convertDesc = convertDesc;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getMinPicPath() {
        return minPicPath;
    }

    public void setMinPicPath(String minPicPath) {
        this.minPicPath = minPicPath;
    }

    public String getMaxPicPath() {
        return maxPicPath;
    }

    public void setMaxPicPath(String maxPicPath) {
        this.maxPicPath = maxPicPath;
    }

}
