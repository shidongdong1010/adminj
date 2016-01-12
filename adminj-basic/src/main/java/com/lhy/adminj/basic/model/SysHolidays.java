package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 节假日表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysHolidays implements Serializable {

    /** 节假日ID **/
    private Long holidaysId;

    /** 年份 **/
    private Long year;

    /** 节假日格式为YYYY-MM-DD **/
    private Date holidays;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 是否有效(Y-是,N-否) **/
    private String isValid;


    public Long getHolidaysId() {
        return holidaysId;
    }

    public void setHolidaysId(Long holidaysId) {
        this.holidaysId = holidaysId;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Date getHolidays() {
        return holidays;
    }

    public void setHolidays(Date holidays) {
        this.holidays = holidays;
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

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

}
