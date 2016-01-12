package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 兑换订单表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertOrder implements Serializable {

    /**  **/
    private Long id;

    /** 订单号 **/
    private String orderNo;

    /** 订单时间 **/
    private Date orderTime;

    /** 订单状态(0-成功,1-失败) **/
    private Long orderStatus;

    /** 用户ID **/
    private Long userId;

    /** 用户名 **/
    private String userName;

    /** 用户手机 **/
    private String userMobile;

    /** 商品ID **/
    private Long goodId;

    /** 商品名称 **/
    private String goodName;

    /** 商品描述 **/
    private String goodSummary;

    /** 支付金币 **/
    private Double payCoin;

    /** 数量 **/
    private Long num;

    /** 快递订单号 **/
    private String expressNo;

    /** 快递类型 **/
    private Long expressType;

    /** 收件人姓名 **/
    private String expressName;

    /** 收件地址 **/
    private String expressAddr;

    /** 收件人手机 **/
    private String expressMobile;

    /** 状态(1-订单待确认，2-订单已确认，3-配送中，4-订单完成，5-订单失败，6-退货中,7-退货完成) **/
    private Long status;

    /** 邮编 **/
    private String zipCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodSummary() {
        return goodSummary;
    }

    public void setGoodSummary(String goodSummary) {
        this.goodSummary = goodSummary;
    }

    public Double getPayCoin() {
        return payCoin;
    }

    public void setPayCoin(Double payCoin) {
        this.payCoin = payCoin;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public Long getExpressType() {
        return expressType;
    }

    public void setExpressType(Long expressType) {
        this.expressType = expressType;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressAddr() {
        return expressAddr;
    }

    public void setExpressAddr(String expressAddr) {
        this.expressAddr = expressAddr;
    }

    public String getExpressMobile() {
        return expressMobile;
    }

    public void setExpressMobile(String expressMobile) {
        this.expressMobile = expressMobile;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
