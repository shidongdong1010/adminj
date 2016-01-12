package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.ResetMonitor;

/**
 * 股票数据清理监控表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ResetMonitorBaseService {

	public void save(ResetMonitor resetMonitor);
	
	public void update(ResetMonitor resetMonitor);

	public void modify(ResetMonitor resetMonitor);

	public void delete(Long resetId);

	public void batchSave(List<ResetMonitor> list);

    public void batchUpdate(List<ResetMonitor> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param resetId 清理ID
	 * @return ResetMonitor
	 */
	public ResetMonitor findById(Long resetId);

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor);

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders);

	/**
	 * 根据对象查询
	 * @param resetMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param resetMonitor
	 * @return Long
	 */
	public Long count(ResetMonitor resetMonitor);
}
