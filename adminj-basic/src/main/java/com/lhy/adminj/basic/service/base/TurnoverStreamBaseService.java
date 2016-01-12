package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.TurnoverStream;

/**
 * Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface TurnoverStreamBaseService {

	public void save(TurnoverStream turnoverStream);
	
	public void update(TurnoverStream turnoverStream);

	public void delete(Long id);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return TurnoverStream
	 */
	public TurnoverStream findById(Long id);

	/**
	 * 根据对象查询
	 * @param turnoverStream
	 * @return List
	 */
	public List<TurnoverStream> find(TurnoverStream turnoverStream);

	/**
	 * 根据对象查询
	 * @param turnoverStream
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TurnoverStream> find(TurnoverStream turnoverStream, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param turnoverStream
	 * @return Long
	 */
	public Long count(TurnoverStream turnoverStream);
}
