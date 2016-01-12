package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户航币使用流水表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinUseFlow implements Serializable {

    /** 航币使用流水ID,自增 **/
    private Long useFlowId;

    /** 用户ID **/
    private Long userId;

    /** 打赏分类(1-查看说说,2-查看晒单,3-跟买) **/
    private String awardClass;

    /** 被打赏人用户 **/
    private Long awardUserId;

    /** 打赏航币数 **/
    private Double awardNum;

    /** 创建日期 **/
    private Date createDate;

    /** 更新时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;

    /** 航币使用业务ID **/
    private Long useServId;


    public Long getUseFlowId() {
        return useFlowId;
    }

    public void setUseFlowId(Long useFlowId) {
        this.useFlowId = useFlowId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAwardClass() {
        return awardClass;
    }

    public void setAwardClass(String awardClass) {
        this.awardClass = awardClass;
    }

    public Long getAwardUserId() {
        return awardUserId;
    }

    public void setAwardUserId(Long awardUserId) {
        this.awardUserId = awardUserId;
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

    public Long getUseServId() {
        return useServId;
    }

    public void setUseServId(Long useServId) {
        this.useServId = useServId;
    }

}
