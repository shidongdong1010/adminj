package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 推送消息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class PushMessage implements Serializable {

    /** 推送ID **/
    private Long pushId;

    /** 消息标题 **/
    private String pushTitle;

    /** 消息内容 **/
    private String pushContent;

    /** 推送时间 **/
    private Date pushTime;

    /** 客户端类型[0:android, 1:IOS] **/
    private Long clientType;

    /** 网络类型[0全部, 1仅wifi] **/
    private Long clientNetwork;

    /** 模板类型[0透传,1通知栏打开应用] **/
    private Long templateType;

    /** 推送结果[0成功,1失败] **/
    private Long pushResult;

    /** 推送的返回字符串 **/
    private String pushResponse;

    /** 客户端ID **/
    private String clientId;

    /** 是否推送[0已推送,1未推送] **/
    private Long isPush;

    /** 在线推送[0仅在线推送，1全部推送] **/
    private Long isOnlinePush;

    /** 消息类型  (此处和原生约定), 0用户消息 , 1用户消息 **/
    private Long msgType;

    /** 消息对应的业务类型(由系统而定） **/
    private Long bueType;


    public Long getPushId() {
        return pushId;
    }

    public void setPushId(Long pushId) {
        this.pushId = pushId;
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Long getClientType() {
        return clientType;
    }

    public void setClientType(Long clientType) {
        this.clientType = clientType;
    }

    public Long getClientNetwork() {
        return clientNetwork;
    }

    public void setClientNetwork(Long clientNetwork) {
        this.clientNetwork = clientNetwork;
    }

    public Long getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Long templateType) {
        this.templateType = templateType;
    }

    public Long getPushResult() {
        return pushResult;
    }

    public void setPushResult(Long pushResult) {
        this.pushResult = pushResult;
    }

    public String getPushResponse() {
        return pushResponse;
    }

    public void setPushResponse(String pushResponse) {
        this.pushResponse = pushResponse;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getIsPush() {
        return isPush;
    }

    public void setIsPush(Long isPush) {
        this.isPush = isPush;
    }

    public Long getIsOnlinePush() {
        return isOnlinePush;
    }

    public void setIsOnlinePush(Long isOnlinePush) {
        this.isOnlinePush = isOnlinePush;
    }

    public Long getMsgType() {
        return msgType;
    }

    public void setMsgType(Long msgType) {
        this.msgType = msgType;
    }

    public Long getBueType() {
        return bueType;
    }

    public void setBueType(Long bueType) {
        this.bueType = bueType;
    }

}
