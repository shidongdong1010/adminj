package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TurnoverStream implements Serializable {

    /**  **/
    private Long id;

    /**  **/
    private Date date;

    /**  **/
    private Long stockId;

    /**  **/
    private String content;

    /**  **/
    private Long fidKkh;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getFidKkh() {
        return fidKkh;
    }

    public void setFidKkh(Long fidKkh) {
        this.fidKkh = fidKkh;
    }

}
