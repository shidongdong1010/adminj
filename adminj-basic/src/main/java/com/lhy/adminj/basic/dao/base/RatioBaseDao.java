package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.Ratio;

/**
 * 浮动表(涨幅、跌幅、换手率、振幅榜)Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface RatioBaseDao {

	public void save(Ratio ratio);
	
	public void update(Ratio ratio);

	public void delete(Long ratioId);

	/**
	 * 根据主键查询
	 * @param ratioId 浮动表主键
	 * @return Ratio
	 */
	public Ratio findById(Long ratioId);

	/**
	 * 根据对象查询
	 * @param ratio
	 * @return List
	 */
	public List<Ratio> find(Ratio ratio);

	/**
	 * 根据对象查询
	 * @param ratio
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Ratio> find(Ratio ratio, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param ratio
	 * @return Long
	 */
	public Long count(Ratio ratio);
}
