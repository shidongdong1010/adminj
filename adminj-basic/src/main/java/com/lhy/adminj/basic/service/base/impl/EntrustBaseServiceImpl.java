package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.EntrustBaseService;
import com.lhy.adminj.basic.dao.EntrustDao;

import com.lhy.adminj.basic.model.Entrust;

/**
 * 股票委托表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class EntrustBaseServiceImpl implements EntrustBaseService{
	@Autowired
	protected EntrustDao entrustDao;

	@Override
	public void save(Entrust entrust) {
		entrustDao.save(entrust);
	}
	
	@Override
	public void update(Entrust entrust) {
		entrustDao.update(entrust);
	}

	@Override
	public void delete(Long entrustId){
		entrustDao.delete(entrustId);
	}

	/**
	 * 根据主键查询
	 * @param entrustId 股票委托表主键
	 * @return Entrust
	 */
	public Entrust findById(Long entrustId){
		return entrustDao.findById(entrustId);
	}

	/**
	 * 根据对象查询
	 * @param entrust
	 * @return List
	 */
	public List<Entrust> find(Entrust entrust){
		return entrustDao.find(entrust);
	}

	/**
	 * 根据对象查询
	 * @param entrust
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Entrust> find(Entrust entrust, Long offset, Long rows){
		return entrustDao.find(entrust, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param entrust
	 * @return Long
	 */
	public Long count(Entrust entrust){
		return entrustDao.count(entrust);
	}
}