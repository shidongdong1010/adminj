package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UOperLogBaseService;
import com.lhy.adminj.basic.dao.UOperLogDao;

import com.lhy.adminj.basic.model.UOperLog;

/**
 * 操作日志Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UOperLogBaseServiceImpl implements UOperLogBaseService{
	@Autowired
	protected UOperLogDao uOperLogDao;

	@Override
	public void save(UOperLog uOperLog) {
		uOperLogDao.save(uOperLog);
	}
	
	@Override
	public void update(UOperLog uOperLog) {
		uOperLogDao.update(uOperLog);
	}

	@Override
	public void modify(UOperLog uOperLog) {
		uOperLogDao.modify(uOperLog);
	}

	@Override
	public void delete(Long id){
		uOperLogDao.delete(id);
	}

	@Override
	public void batchSave(List<UOperLog> list){
		uOperLogDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UOperLog> list){
		uOperLogDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uOperLogDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UOperLog
	 */
	public UOperLog findById(Long id){
		return uOperLogDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog){
		return uOperLogDao.find(uOperLog);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders){
		return uOperLogDao.find(uOperLog, orders);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, Long offset, Long rows){
		return uOperLogDao.find(uOperLog, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders, Long offset, Long rows){
    	return uOperLogDao.find(uOperLog, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uOperLog
	 * @return Long
	 */
	public Long count(UOperLog uOperLog){
		return uOperLogDao.count(uOperLog);
	}
}