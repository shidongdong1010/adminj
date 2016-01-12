package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.KhnoBaseService;
import com.lhy.adminj.basic.dao.KhnoDao;

import com.lhy.adminj.basic.model.Khno;

/**
 * Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class KhnoBaseServiceImpl implements KhnoBaseService{
	@Autowired
	protected KhnoDao khnoDao;

	@Override
	public void save(Khno khno) {
		khnoDao.save(khno);
	}
	
	@Override
	public void update(Khno khno) {
		khnoDao.update(khno);
	}

	@Override
	public void modify(Khno khno) {
		khnoDao.modify(khno);
	}

	@Override
	public void delete(String khno){
		khnoDao.delete(khno);
	}

	@Override
	public void batchSave(List<Khno> list){
		khnoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<Khno> list){
		khnoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		khnoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param khno 客户号
	 * @return Khno
	 */
	public Khno findById(String khno){
		return khnoDao.findById(khno);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @return List
	 */
	public List<Khno> find(Khno khno){
		return khnoDao.find(khno);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Khno> find(Khno khno, String[][] orders){
		return khnoDao.find(khno, orders);
	}

	/**
	 * 根据对象查询
	 * @param khno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Khno> find(Khno khno, Long offset, Long rows){
		return khnoDao.find(khno, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Khno> find(Khno khno, String[][] orders, Long offset, Long rows){
    	return khnoDao.find(khno, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param khno
	 * @return Long
	 */
	public Long count(Khno khno){
		return khnoDao.count(khno);
	}
}