package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 敏感词库
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSensitiveWord implements Serializable {

    /** 敏感词ID **/
    private Long wordId;

    /**  **/
    private String word;

    /** 匹配类型(1-最小匹配, 2-最大匹配) **/
    private String mathType;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 是否有效(Y-是,N-否) **/
    private String isValid;


    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMathType() {
        return mathType;
    }

    public void setMathType(String mathType) {
        this.mathType = mathType;
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
