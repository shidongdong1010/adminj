package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Brokers;

/**
 * 券商管理表，后期接入的券商都通过此表进行管理Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface BrokersBaseService {

	public void save(Brokers brokers);
	
	public void update(Brokers brokers);

	public void delete(Long brokerId);

	/**
	 * 根据主键查询
	 * @param brokerId 
	 * @return Brokers
	 */
	public Brokers findById(Long brokerId);

	/**
	 * 根据对象查询
	 * @param brokers
	 * @return List
	 */
	public List<Brokers> find(Brokers brokers);

	/**
	 * 根据对象查询
	 * @param brokers
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Brokers> find(Brokers brokers, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param brokers
	 * @return Long
	 */
	public Long count(Brokers brokers);
}
