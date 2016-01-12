package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 证券历史交易查询
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class HisTrade implements Serializable {

    /** 主键 **/
    private Long smcId;

    /** 券商客户号 **/
    private String fidKhh;

    /** 平台用户主键 **/
    private Long userId;

    /** 券商定位串 **/
    private String fidBrowindex;

    /** 成交日期 **/
    private Double fidCjrq;

    /** 交易所 **/
    private String fidJys;

    /** 股东号 **/
    private String fidGdh;

    /** 币种 **/
    private String fidBz;

    /** 委托号 **/
    private Double fidWth;

    /** 交易类型（买入、卖出） **/
    private String fidWtlb;

    /** 证券代码 **/
    private String fidZqdm;

    /** 证券名称 **/
    private String fidZqmc;

    /** 成交时间 **/
    private String fidCjsj;

    /** 成交数量 **/
    private Double fidCjsl;

    /** 成交价格 **/
    private Double fidCjjg;

    /** 结算价 **/
    private Double fidJsj;

    /** 成交金额 **/
    private Double fidCjje;

    /** 标准佣金 **/
    private Double fidBzs1;

    /** 实收佣金 **/
    private Double fidS1;

    /** 印花税 **/
    private Double fidS2;

    /** 过户费 **/
    private Double fidS3;

    /** 附加费 **/
    private Double fidS4;

    /** 结算费 **/
    private Double fidS5;

    /** 其它费 **/
    private Double fidS6;

    /** 一级手续费 **/
    private String fidS11;

    /** 一级证管费 **/
    private String fidS12;

    /** 一级过户费 **/
    private String fidS13;

    /** 成交标号 **/
    private String fidCjbh;

    /** 成交笔数 **/
    private Double fidCjbs;

    /** 应收金额 **/
    private Double fidYsje;

    /** 证券余额 **/
    private Double fidBczqsl;

    /** 资金余额 **/
    private Double fidBczjye;

    /** 交易所费用 **/
    private Double fidJysfy;

    /** 净佣金 **/
    private Double fidJyfy;

    /** 交收日期 **/
    private Double fidJsrq;

    /** 利息金额 **/
    private Double fidLxje;

    /** 操作日期 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最后更新时间 **/
    private Date lastUpdateDate;

    /** 最后更新人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;


    public Long getSmcId() {
        return smcId;
    }

    public void setSmcId(Long smcId) {
        this.smcId = smcId;
    }

    public String getFidKhh() {
        return fidKhh;
    }

    public void setFidKhh(String fidKhh) {
        this.fidKhh = fidKhh;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFidBrowindex() {
        return fidBrowindex;
    }

    public void setFidBrowindex(String fidBrowindex) {
        this.fidBrowindex = fidBrowindex;
    }

    public Double getFidCjrq() {
        return fidCjrq;
    }

    public void setFidCjrq(Double fidCjrq) {
        this.fidCjrq = fidCjrq;
    }

    public String getFidJys() {
        return fidJys;
    }

    public void setFidJys(String fidJys) {
        this.fidJys = fidJys;
    }

    public String getFidGdh() {
        return fidGdh;
    }

    public void setFidGdh(String fidGdh) {
        this.fidGdh = fidGdh;
    }

    public String getFidBz() {
        return fidBz;
    }

    public void setFidBz(String fidBz) {
        this.fidBz = fidBz;
    }

    public Double getFidWth() {
        return fidWth;
    }

    public void setFidWth(Double fidWth) {
        this.fidWth = fidWth;
    }

    public String getFidWtlb() {
        return fidWtlb;
    }

    public void setFidWtlb(String fidWtlb) {
        this.fidWtlb = fidWtlb;
    }

    public String getFidZqdm() {
        return fidZqdm;
    }

    public void setFidZqdm(String fidZqdm) {
        this.fidZqdm = fidZqdm;
    }

    public String getFidZqmc() {
        return fidZqmc;
    }

    public void setFidZqmc(String fidZqmc) {
        this.fidZqmc = fidZqmc;
    }

    public String getFidCjsj() {
        return fidCjsj;
    }

    public void setFidCjsj(String fidCjsj) {
        this.fidCjsj = fidCjsj;
    }

    public Double getFidCjsl() {
        return fidCjsl;
    }

    public void setFidCjsl(Double fidCjsl) {
        this.fidCjsl = fidCjsl;
    }

    public Double getFidCjjg() {
        return fidCjjg;
    }

    public void setFidCjjg(Double fidCjjg) {
        this.fidCjjg = fidCjjg;
    }

    public Double getFidJsj() {
        return fidJsj;
    }

    public void setFidJsj(Double fidJsj) {
        this.fidJsj = fidJsj;
    }

    public Double getFidCjje() {
        return fidCjje;
    }

    public void setFidCjje(Double fidCjje) {
        this.fidCjje = fidCjje;
    }

    public Double getFidBzs1() {
        return fidBzs1;
    }

    public void setFidBzs1(Double fidBzs1) {
        this.fidBzs1 = fidBzs1;
    }

    public Double getFidS1() {
        return fidS1;
    }

    public void setFidS1(Double fidS1) {
        this.fidS1 = fidS1;
    }

    public Double getFidS2() {
        return fidS2;
    }

    public void setFidS2(Double fidS2) {
        this.fidS2 = fidS2;
    }

    public Double getFidS3() {
        return fidS3;
    }

    public void setFidS3(Double fidS3) {
        this.fidS3 = fidS3;
    }

    public Double getFidS4() {
        return fidS4;
    }

    public void setFidS4(Double fidS4) {
        this.fidS4 = fidS4;
    }

    public Double getFidS5() {
        return fidS5;
    }

    public void setFidS5(Double fidS5) {
        this.fidS5 = fidS5;
    }

    public Double getFidS6() {
        return fidS6;
    }

    public void setFidS6(Double fidS6) {
        this.fidS6 = fidS6;
    }

    public String getFidS11() {
        return fidS11;
    }

    public void setFidS11(String fidS11) {
        this.fidS11 = fidS11;
    }

    public String getFidS12() {
        return fidS12;
    }

    public void setFidS12(String fidS12) {
        this.fidS12 = fidS12;
    }

    public String getFidS13() {
        return fidS13;
    }

    public void setFidS13(String fidS13) {
        this.fidS13 = fidS13;
    }

    public String getFidCjbh() {
        return fidCjbh;
    }

    public void setFidCjbh(String fidCjbh) {
        this.fidCjbh = fidCjbh;
    }

    public Double getFidCjbs() {
        return fidCjbs;
    }

    public void setFidCjbs(Double fidCjbs) {
        this.fidCjbs = fidCjbs;
    }

    public Double getFidYsje() {
        return fidYsje;
    }

    public void setFidYsje(Double fidYsje) {
        this.fidYsje = fidYsje;
    }

    public Double getFidBczqsl() {
        return fidBczqsl;
    }

    public void setFidBczqsl(Double fidBczqsl) {
        this.fidBczqsl = fidBczqsl;
    }

    public Double getFidBczjye() {
        return fidBczjye;
    }

    public void setFidBczjye(Double fidBczjye) {
        this.fidBczjye = fidBczjye;
    }

    public Double getFidJysfy() {
        return fidJysfy;
    }

    public void setFidJysfy(Double fidJysfy) {
        this.fidJysfy = fidJysfy;
    }

    public Double getFidJyfy() {
        return fidJyfy;
    }

    public void setFidJyfy(Double fidJyfy) {
        this.fidJyfy = fidJyfy;
    }

    public Double getFidJsrq() {
        return fidJsrq;
    }

    public void setFidJsrq(Double fidJsrq) {
        this.fidJsrq = fidJsrq;
    }

    public Double getFidLxje() {
        return fidLxje;
    }

    public void setFidLxje(Double fidLxje) {
        this.fidLxje = fidLxje;
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
