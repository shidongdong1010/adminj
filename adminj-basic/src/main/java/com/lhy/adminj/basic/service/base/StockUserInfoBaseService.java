package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.StockUserInfo;

/**
 * 平台客户和证券客户关联Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockUserInfoBaseService {

	public void save(StockUserInfo stockUserInfo);
	
	public void update(StockUserInfo stockUserInfo);

	public void delete(Long stockUserInfoId);

	/**
	 * 根据主键查询
	 * @param stockUserInfoId 主键
	 * @return StockUserInfo
	 */
	public StockUserInfo findById(Long stockUserInfoId);

	/**
	 * 根据对象查询
	 * @param stockUserInfo
	 * @return List
	 */
	public List<StockUserInfo> find(StockUserInfo stockUserInfo);

	/**
	 * 根据对象查询
	 * @param stockUserInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockUserInfo> find(StockUserInfo stockUserInfo, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stockUserInfo
	 * @return Long
	 */
	public Long count(StockUserInfo stockUserInfo);
}
