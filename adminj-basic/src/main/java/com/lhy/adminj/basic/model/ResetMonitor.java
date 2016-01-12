package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 股票数据清理监控表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResetMonitor implements Serializable {

    /** 清理ID **/
    private Long resetId;

    /** 清理时间 **/
    private Date resetDate;

    /** 清理哪天的数据 **/
    private Date resetDataDate;

    /** 交易数清理0:未开始1:请理完成2:出现异常 **/
    private String positionNumReset;

    /** 持仓股票为0清理0:未开始1:请理完成2:出现异常 **/
    private String delPositionStock;

    /** 组合今日收益清理0:未开始1:请理完成2:出现异常 **/
    private String groupIncomeReset;

    /** 组合详情今日收益清理0:未开始1:请理完成2:出现异常 **/
    private String groupDetailIncomeReset;

    /** 组合详情数据清理0:未开始1:请理完成2:出现异常 **/
    private String delGroupDetail;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getResetId() {
        return resetId;
    }

    public void setResetId(Long resetId) {
        this.resetId = resetId;
    }

    public Date getResetDate() {
        return resetDate;
    }

    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }

    public Date getResetDataDate() {
        return resetDataDate;
    }

    public void setResetDataDate(Date resetDataDate) {
        this.resetDataDate = resetDataDate;
    }

    public String getPositionNumReset() {
        return positionNumReset;
    }

    public void setPositionNumReset(String positionNumReset) {
        this.positionNumReset = positionNumReset;
    }

    public String getDelPositionStock() {
        return delPositionStock;
    }

    public void setDelPositionStock(String delPositionStock) {
        this.delPositionStock = delPositionStock;
    }

    public String getGroupIncomeReset() {
        return groupIncomeReset;
    }

    public void setGroupIncomeReset(String groupIncomeReset) {
        this.groupIncomeReset = groupIncomeReset;
    }

    public String getGroupDetailIncomeReset() {
        return groupDetailIncomeReset;
    }

    public void setGroupDetailIncomeReset(String groupDetailIncomeReset) {
        this.groupDetailIncomeReset = groupDetailIncomeReset;
    }

    public String getDelGroupDetail() {
        return delGroupDetail;
    }

    public void setDelGroupDetail(String delGroupDetail) {
        this.delGroupDetail = delGroupDetail;
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
