package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.ActualBackupMonitorBaseService;
import com.lhy.adminj.basic.dao.ActualBackupMonitorDao;

import com.lhy.adminj.basic.model.ActualBackupMonitor;

/**
 * 时段数据备份Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ActualBackupMonitorBaseServiceImpl implements ActualBackupMonitorBaseService{
	@Autowired
	protected ActualBackupMonitorDao actualBackupMonitorDao;

	@Override
	public void save(ActualBackupMonitor actualBackupMonitor) {
		actualBackupMonitorDao.save(actualBackupMonitor);
	}
	
	@Override
	public void update(ActualBackupMonitor actualBackupMonitor) {
		actualBackupMonitorDao.update(actualBackupMonitor);
	}

	@Override
	public void modify(ActualBackupMonitor actualBackupMonitor) {
		actualBackupMonitorDao.modify(actualBackupMonitor);
	}

	@Override
	public void delete(Long backupId){
		actualBackupMonitorDao.delete(backupId);
	}

	@Override
	public void batchSave(List<ActualBackupMonitor> list){
		actualBackupMonitorDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<ActualBackupMonitor> list){
		actualBackupMonitorDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		actualBackupMonitorDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param backupId 备份ID
	 * @return ActualBackupMonitor
	 */
	public ActualBackupMonitor findById(Long backupId){
		return actualBackupMonitorDao.findById(backupId);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor){
		return actualBackupMonitorDao.find(actualBackupMonitor);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders){
		return actualBackupMonitorDao.find(actualBackupMonitor, orders);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, Long offset, Long rows){
		return actualBackupMonitorDao.find(actualBackupMonitor, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders, Long offset, Long rows){
    	return actualBackupMonitorDao.find(actualBackupMonitor, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param actualBackupMonitor
	 * @return Long
	 */
	public Long count(ActualBackupMonitor actualBackupMonitor){
		return actualBackupMonitorDao.count(actualBackupMonitor);
	}
}