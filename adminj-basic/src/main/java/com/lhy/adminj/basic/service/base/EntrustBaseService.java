package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Entrust;

/**
 * 股票委托表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface EntrustBaseService {

	public void save(Entrust entrust);
	
	public void update(Entrust entrust);

	public void delete(Long entrustId);

	/**
	 * 根据主键查询
	 * @param entrustId 股票委托表主键
	 * @return Entrust
	 */
	public Entrust findById(Long entrustId);

	/**
	 * 根据对象查询
	 * @param entrust
	 * @return List
	 */
	public List<Entrust> find(Entrust entrust);

	/**
	 * 根据对象查询
	 * @param entrust
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Entrust> find(Entrust entrust, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param entrust
	 * @return Long
	 */
	public Long count(Entrust entrust);
}
