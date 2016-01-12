package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 时段数据备份
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ActualBackupMonitor implements Serializable {

    /** 备份ID **/
    private Long backupId;

    /** 备份时间yyyy-MM-dd **/
    private Date backupTime;

    /** 数据备份类型1:组合2:组合详情3:用户持仓4:股票 **/
    private String backupType;

    /** 九点半数据备份状态0:未启动1:备份表完成2:备份表异常3:备份数据完成4:备份数据异常5:组合时段计算完成6:组合时段计算出现异常7:个人时段计算完成8:个人时段计算出现异常 **/
    private String nineHalfStatus;

    /** 十点半数据备份状态0:未启动1:备份表完成2:备份表异常3:备份数据完成4:备份数据异常5:组合时段计算完成6:组合时段计算出现异常7:个人时段计算完成8:个人时段计算出现异常 **/
    private String tenHalfStatus;

    /** 十一点半数据备份状态0:未启动1:备份表完成2:备份表异常3:备份数据完成4:备份数据异常5:组合时段计算完成6:组合时段计算出现异常7:个人时段计算完成8:个人时段计算出现异常 **/
    private String elevenHalfStatus;

    /** 14点数据备份状态0:未启动1:备份表完成2:备份表异常3:备份数据完成4:备份数据异常5:组合时段计算完成6:组合时段计算出现异常7:个人时段计算完成8:个人时段计算出现异常 **/
    private String fourteenStatus;

    /** 15点数据备份状态0:未启动1:备份表完成2:备份表异常3:备份数据完成4:备份数据异常5:组合时段计算完成6:组合时段计算出现异常7:个人时段计算完成8:个人时段计算出现异常 **/
    private String fifteenStatus;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getBackupId() {
        return backupId;
    }

    public void setBackupId(Long backupId) {
        this.backupId = backupId;
    }

    public Date getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(Date backupTime) {
        this.backupTime = backupTime;
    }

    public String getBackupType() {
        return backupType;
    }

    public void setBackupType(String backupType) {
        this.backupType = backupType;
    }

    public String getNineHalfStatus() {
        return nineHalfStatus;
    }

    public void setNineHalfStatus(String nineHalfStatus) {
        this.nineHalfStatus = nineHalfStatus;
    }

    public String getTenHalfStatus() {
        return tenHalfStatus;
    }

    public void setTenHalfStatus(String tenHalfStatus) {
        this.tenHalfStatus = tenHalfStatus;
    }

    public String getElevenHalfStatus() {
        return elevenHalfStatus;
    }

    public void setElevenHalfStatus(String elevenHalfStatus) {
        this.elevenHalfStatus = elevenHalfStatus;
    }

    public String getFourteenStatus() {
        return fourteenStatus;
    }

    public void setFourteenStatus(String fourteenStatus) {
        this.fourteenStatus = fourteenStatus;
    }

    public String getFifteenStatus() {
        return fifteenStatus;
    }

    public void setFifteenStatus(String fifteenStatus) {
        this.fifteenStatus = fifteenStatus;
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

}
