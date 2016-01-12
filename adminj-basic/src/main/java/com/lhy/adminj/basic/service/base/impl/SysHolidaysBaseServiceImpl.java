package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.SysHolidaysBaseService;
import com.lhy.adminj.basic.dao.SysHolidaysDao;

import com.lhy.adminj.basic.model.SysHolidays;

/**
 * 节假日表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysHolidaysBaseServiceImpl implements SysHolidaysBaseService{
	@Autowired
	protected SysHolidaysDao sysHolidaysDao;

	@Override
	public void save(SysHolidays sysHolidays) {
		sysHolidaysDao.save(sysHolidays);
	}
	
	@Override
	public void update(SysHolidays sysHolidays) {
		sysHolidaysDao.update(sysHolidays);
	}

	@Override
	public void modify(SysHolidays sysHolidays) {
		sysHolidaysDao.modify(sysHolidays);
	}

	@Override
	public void delete(Long holidaysId){
		sysHolidaysDao.delete(holidaysId);
	}

	@Override
	public void batchSave(List<SysHolidays> list){
		sysHolidaysDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<SysHolidays> list){
		sysHolidaysDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		sysHolidaysDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param holidaysId 节假日ID
	 * @return SysHolidays
	 */
	public SysHolidays findById(Long holidaysId){
		return sysHolidaysDao.findById(holidaysId);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays){
		return sysHolidaysDao.find(sysHolidays);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders){
		return sysHolidaysDao.find(sysHolidays, orders);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, Long offset, Long rows){
		return sysHolidaysDao.find(sysHolidays, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders, Long offset, Long rows){
    	return sysHolidaysDao.find(sysHolidays, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param sysHolidays
	 * @return Long
	 */
	public Long count(SysHolidays sysHolidays){
		return sysHolidaysDao.count(sysHolidays);
	}
}