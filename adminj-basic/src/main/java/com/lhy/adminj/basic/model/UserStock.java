package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 自选股
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStock implements Serializable {

    /** 自选股表主键 **/
    private Long userStockId;

    /** 平台用户 **/
    private Long userId;

    /** 股票名称  **/
    private String name;

    /** 股票代码  **/
    private String code;

    /** 操作日期 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最后操作时间 **/
    private Date lastUpdateDate;

    /** 最后操作人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;


    public Long getUserStockId() {
        return userStockId;
    }

    public void setUserStockId(Long userStockId) {
        this.userStockId = userStockId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(Long lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public Long getDr() {
        return dr;
    }

    public void setDr(Long dr) {
        this.dr = dr;
    }

}
