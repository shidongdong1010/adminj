package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 相遇历史记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MeetHistory implements Serializable {

    /** 相遇历史记录ID **/
    private Long meetHisId;

    /** 用户ID **/
    private Long userId;

    /** 遇见的人的ID **/
    private Long meetUserId;

    /** 相遇城市 **/
    private String meetCityCode;

    /**  **/
    private Date meetData;

    /** 打招呼内容 **/
    private String say;


    public Long getMeetHisId() {
        return meetHisId;
    }

    public void setMeetHisId(Long meetHisId) {
        this.meetHisId = meetHisId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMeetUserId() {
        return meetUserId;
    }

    public void setMeetUserId(Long meetUserId) {
        this.meetUserId = meetUserId;
    }

    public String getMeetCityCode() {
        return meetCityCode;
    }

    public void setMeetCityCode(String meetCityCode) {
        this.meetCityCode = meetCityCode;
    }

    public Date getMeetData() {
        return meetData;
    }

    public void setMeetData(Date meetData) {
        this.meetData = meetData;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

}
