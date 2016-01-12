package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.HisTrade;

/**
 * 证券历史交易查询Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface HisTradeBaseService {

	public void save(HisTrade hisTrade);
	
	public void update(HisTrade hisTrade);

	public void delete(Long smcId);

	/**
	 * 根据主键查询
	 * @param smcId 主键
	 * @return HisTrade
	 */
	public HisTrade findById(Long smcId);

	/**
	 * 根据对象查询
	 * @param hisTrade
	 * @return List
	 */
	public List<HisTrade> find(HisTrade hisTrade);

	/**
	 * 根据对象查询
	 * @param hisTrade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<HisTrade> find(HisTrade hisTrade, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param hisTrade
	 * @return Long
	 */
	public Long count(HisTrade hisTrade);
}
