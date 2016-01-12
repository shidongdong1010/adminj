package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.CjhbBaseService;
import com.lhy.adminj.basic.dao.CjhbDao;

import com.lhy.adminj.basic.model.Cjhb;

/**
 * Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CjhbBaseServiceImpl implements CjhbBaseService{
	@Autowired
	protected CjhbDao cjhbDao;

	@Override
	public void save(Cjhb cjhb) {
		cjhbDao.save(cjhb);
	}
	
	@Override
	public void update(Cjhb cjhb) {
		cjhbDao.update(cjhb);
	}

	@Override
	public void modify(Cjhb cjhb) {
		cjhbDao.modify(cjhb);
	}

	@Override
	public void delete(Long id){
		cjhbDao.delete(id);
	}

	@Override
	public void batchSave(List<Cjhb> list){
		cjhbDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<Cjhb> list){
		cjhbDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		cjhbDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return Cjhb
	 */
	public Cjhb findById(Long id){
		return cjhbDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb){
		return cjhbDao.find(cjhb);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, String[][] orders){
		return cjhbDao.find(cjhb, orders);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, Long offset, Long rows){
		return cjhbDao.find(cjhb, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, String[][] orders, Long offset, Long rows){
    	return cjhbDao.find(cjhb, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param cjhb
	 * @return Long
	 */
	public Long count(Cjhb cjhb){
		return cjhbDao.count(cjhb);
	}
}