package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.ActualBackupMonitor;

/**
 * 时段数据备份Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ActualBackupMonitorBaseService {

	public void save(ActualBackupMonitor actualBackupMonitor);
	
	public void update(ActualBackupMonitor actualBackupMonitor);

	public void modify(ActualBackupMonitor actualBackupMonitor);

	public void delete(Long backupId);

	public void batchSave(List<ActualBackupMonitor> list);

    public void batchUpdate(List<ActualBackupMonitor> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param backupId 备份ID
	 * @return ActualBackupMonitor
	 */
	public ActualBackupMonitor findById(Long backupId);

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor);

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders);

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param actualBackupMonitor
	 * @return Long
	 */
	public Long count(ActualBackupMonitor actualBackupMonitor);
}
