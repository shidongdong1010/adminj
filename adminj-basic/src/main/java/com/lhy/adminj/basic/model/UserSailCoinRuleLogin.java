package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录航币奖励规则表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRuleLogin implements Serializable {

    /** 规则ID **/
    private Long ruleId;

    /** 规则类型[4-连续登录] **/
    private String ruleType;

    /** 规则类型 **/
    private String ruleName;

    /** 起始天数 **/
    private Long minDay;

    /** 结束天数 **/
    private Long maxDay;

    /** 有效时间 **/
    private Date effeTime;

    /** 失效时间 **/
    private Date failTime;

    /** 奖励航币数 **/
    private Double coinNum;


    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getMinDay() {
        return minDay;
    }

    public void setMinDay(Long minDay) {
        this.minDay = minDay;
    }

    public Long getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(Long maxDay) {
        this.maxDay = maxDay;
    }

    public Date getEffeTime() {
        return effeTime;
    }

    public void setEffeTime(Date effeTime) {
        this.effeTime = effeTime;
    }

    public Date getFailTime() {
        return failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    public Double getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Double coinNum) {
        this.coinNum = coinNum;
    }

}
