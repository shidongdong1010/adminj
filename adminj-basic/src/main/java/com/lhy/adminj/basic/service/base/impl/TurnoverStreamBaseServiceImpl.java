package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.TurnoverStreamBaseService;
import com.lhy.adminj.basic.dao.TurnoverStreamDao;

import com.lhy.adminj.basic.model.TurnoverStream;

/**
 * Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TurnoverStreamBaseServiceImpl implements TurnoverStreamBaseService{
	@Autowired
	protected TurnoverStreamDao turnoverStreamDao;

	@Override
	public void save(TurnoverStream turnoverStream) {
		turnoverStreamDao.save(turnoverStream);
	}
	
	@Override
	public void update(TurnoverStream turnoverStream) {
		turnoverStreamDao.update(turnoverStream);
	}

	@Override
	public void delete(Long id){
		turnoverStreamDao.delete(id);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return TurnoverStream
	 */
	public TurnoverStream findById(Long id){
		return turnoverStreamDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param turnoverStream
	 * @return List
	 */
	public List<TurnoverStream> find(TurnoverStream turnoverStream){
		return turnoverStreamDao.find(turnoverStream);
	}

	/**
	 * 根据对象查询
	 * @param turnoverStream
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TurnoverStream> find(TurnoverStream turnoverStream, Long offset, Long rows){
		return turnoverStreamDao.find(turnoverStream, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param turnoverStream
	 * @return Long
	 */
	public Long count(TurnoverStream turnoverStream){
		return turnoverStreamDao.count(turnoverStream);
	}
}