package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Khno implements Serializable {

    /** 客户号 **/
    private String khno;

    /** 1:上海证券 **/
    private Long brokerid;


    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno;
    }

    public Long getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(Long brokerid) {
        this.brokerid = brokerid;
    }

}
