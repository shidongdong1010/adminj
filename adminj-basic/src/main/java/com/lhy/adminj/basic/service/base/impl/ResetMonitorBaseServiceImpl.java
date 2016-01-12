package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.ResetMonitorBaseService;
import com.lhy.adminj.basic.dao.ResetMonitorDao;

import com.lhy.adminj.basic.model.ResetMonitor;

/**
 * 股票数据清理监控表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResetMonitorBaseServiceImpl implements ResetMonitorBaseService{
	@Autowired
	protected ResetMonitorDao resetMonitorDao;

	@Override
	public void save(ResetMonitor resetMonitor) {
		resetMonitorDao.save(resetMonitor);
	}
	
	@Override
	public void update(ResetMonitor resetMonitor) {
		resetMonitorDao.update(resetMonitor);
	}

	@Override
	public void modify(ResetMonitor resetMonitor) {
		resetMonitorDao.modify(resetMonitor);
	}

	@Override
	public void delete(Long resetId){
		resetMonitorDao.delete(resetId);
	}

	@Override
	public void batchSave(List<ResetMonitor> list){
		resetMonitorDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<ResetMonitor> list){
		resetMonitorDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		resetMonitorDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param resetId 清理ID
	 * @return ResetMonitor
	 */
	public ResetMonitor findById(Long resetId){
		return resetMonitorDao.findById(resetId);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor){
		return resetMonitorDao.find(resetMonitor);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders){
		return resetMonitorDao.find(resetMonitor, orders);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, Long offset, Long rows){
		return resetMonitorDao.find(resetMonitor, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders, Long offset, Long rows){
    	return resetMonitorDao.find(resetMonitor, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param resetMonitor
	 * @return Long
	 */
	public Long count(ResetMonitor resetMonitor){
		return resetMonitorDao.count(resetMonitor);
	}
}