package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 城市表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class City implements Serializable {

    /** 城市ID **/
    private Long cityId;

    /** 省份ID **/
    private Long provinceId;

    /** 城市名称 **/
    private String cityName;

    /** 是否显示(Y-显示,N-不显示) **/
    private String validFlag;


    public City() {
        super();
    }

    public City(Long provinceId, String validFlag) {
        super();
        this.provinceId = provinceId;
        this.validFlag = validFlag;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

}
