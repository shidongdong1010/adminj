package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户航币获取流水表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinObtainFlow implements Serializable {

    /** 航币获取流水ID,自增 **/
    private Long obtainFlowId;

    /** 获取方式(1-注册,2-推荐好友下载,3-完善信息,4-连续登录,5-操作,6-发表说说,7-晒单,8-上传头像,9-实名认证,10-绑定银行卡) **/
    private String obtainWay;

    /** 推荐用户ID **/
    private Long recommendUserId;

    /** 得到航币数 **/
    private Double awardNum;

    /** 创建日期 **/
    private Date createDate;

    /** 更新时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;

    /**  **/
    private Long userId;


    public Long getObtainFlowId() {
        return obtainFlowId;
    }

    public void setObtainFlowId(Long obtainFlowId) {
        this.obtainFlowId = obtainFlowId;
    }

    public String getObtainWay() {
        return obtainWay;
    }

    public void setObtainWay(String obtainWay) {
        this.obtainWay = obtainWay;
    }

    public Long getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(Long recommendUserId) {
        this.recommendUserId = recommendUserId;
    }

    public Double getAwardNum() {
        return awardNum;
    }

    public void setAwardNum(Double awardNum) {
        this.awardNum = awardNum;
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
