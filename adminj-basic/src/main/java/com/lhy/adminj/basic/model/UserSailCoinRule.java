package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 航币奖励规则表(除登录)
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRule implements Serializable {

    /** 规则ID **/
    private Long ruleId;

    /** 规则类型[1-注册,2-推荐好友下载,3-完善信息,5-操作,6-发表说说,7-晒单,8-上传头像,9-实名认证,10-绑定银行卡] **/
    private String ruleType;

    /** 规则类型 **/
    private String ruleName;

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
