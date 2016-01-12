package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UOperLog;

/**
 * 操作日志Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UOperLogBaseService {

	public void save(UOperLog uOperLog);
	
	public void update(UOperLog uOperLog);

	public void modify(UOperLog uOperLog);

	public void delete(Long id);

	public void batchSave(List<UOperLog> list);

    public void batchUpdate(List<UOperLog> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UOperLog
	 */
	public UOperLog findById(Long id);

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog);

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uOperLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uOperLog
	 * @return Long
	 */
	public Long count(UOperLog uOperLog);
}
