package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.SysSmsBaseService;
import com.lhy.adminj.basic.dao.SysSmsDao;

import com.lhy.adminj.basic.model.SysSms;

/**
 * 短信信息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSmsBaseServiceImpl implements SysSmsBaseService{
	@Autowired
	protected SysSmsDao sysSmsDao;

	@Override
	public void save(SysSms sysSms) {
		sysSmsDao.save(sysSms);
	}
	
	@Override
	public void update(SysSms sysSms) {
		sysSmsDao.update(sysSms);
	}

	@Override
	public void modify(SysSms sysSms) {
		sysSmsDao.modify(sysSms);
	}

	@Override
	public void delete(Long smsId){
		sysSmsDao.delete(smsId);
	}

	@Override
	public void batchSave(List<SysSms> list){
		sysSmsDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<SysSms> list){
		sysSmsDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		sysSmsDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param smsId 短信ID
	 * @return SysSms
	 */
	public SysSms findById(Long smsId){
		return sysSmsDao.findById(smsId);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms){
		return sysSmsDao.find(sysSms);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, String[][] orders){
		return sysSmsDao.find(sysSms, orders);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, Long offset, Long rows){
		return sysSmsDao.find(sysSms, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, String[][] orders, Long offset, Long rows){
    	return sysSmsDao.find(sysSms, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param sysSms
	 * @return Long
	 */
	public Long count(SysSms sysSms){
		return sysSmsDao.count(sysSms);
	}
}