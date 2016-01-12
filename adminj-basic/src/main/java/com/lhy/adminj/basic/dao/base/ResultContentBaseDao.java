package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.ResultContent;

/**
 * 实时交易表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ResultContentBaseDao {

	public void save(ResultContent resultContent);
	
	public void update(ResultContent resultContent);

	public void delete(Long resultContentId);

	/**
	 * 根据主键查询
	 * @param resultContentId 实时数据表主键
	 * @return ResultContent
	 */
	public ResultContent findById(Long resultContentId);

	/**
	 * 根据对象查询
	 * @param resultContent
	 * @return List
	 */
	public List<ResultContent> find(ResultContent resultContent);

	/**
	 * 根据对象查询
	 * @param resultContent
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResultContent> find(ResultContent resultContent, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param resultContent
	 * @return Long
	 */
	public Long count(ResultContent resultContent);
}
