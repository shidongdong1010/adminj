package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Trader;

/**
 * 券商信息表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface TraderBaseService {

	public void save(Trader trader);
	
	public void update(Trader trader);

	public void delete(Long traderId);

	/**
	 * 根据主键查询
	 * @param traderId 券商ID
	 * @return Trader
	 */
	public Trader findById(Long traderId);

	/**
	 * 根据对象查询
	 * @param trader
	 * @return List
	 */
	public List<Trader> find(Trader trader);

	/**
	 * 根据对象查询
	 * @param trader
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trader> find(Trader trader, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param trader
	 * @return Long
	 */
	public Long count(Trader trader);
}
