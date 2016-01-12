package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 省份表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Province implements Serializable {

    /** 省份ID **/
    private Long provinceId;

    /** 省份中文名称 **/
    private String provCnName;

    /** 省份简称 **/
    private String shortName;

    /** 省份英文名称 **/
    private String provEnName;

    /** 是否显示(Y-显示,N-不显示) **/
    private String validFlag;


    public Province() {
        super();
    }


    public Province(Long provinceId) {
        super();
        this.provinceId = provinceId;
    }


    public Province(String validFlag) {
        super();
        this.validFlag = validFlag;
    }


    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvCnName() {
        return provCnName;
    }

    public void setProvCnName(String provCnName) {
        this.provCnName = provCnName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getProvEnName() {
        return provEnName;
    }

    public void setProvEnName(String provEnName) {
        this.provEnName = provEnName;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}
