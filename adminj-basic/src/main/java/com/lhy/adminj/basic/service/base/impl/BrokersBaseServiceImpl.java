package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.BrokersBaseService;
import com.lhy.adminj.basic.dao.BrokersDao;

import com.lhy.adminj.basic.model.Brokers;

/**
 * 券商管理表，后期接入的券商都通过此表进行管理Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class BrokersBaseServiceImpl implements BrokersBaseService{
	@Autowired
	protected BrokersDao brokersDao;

	@Override
	public void save(Brokers brokers) {
		brokersDao.save(brokers);
	}
	
	@Override
	public void update(Brokers brokers) {
		brokersDao.update(brokers);
	}

	@Override
	public void delete(Long brokerId){
		brokersDao.delete(brokerId);
	}

	/**
	 * 根据主键查询
	 * @param brokerId 
	 * @return Brokers
	 */
	public Brokers findById(Long brokerId){
		return brokersDao.findById(brokerId);
	}

	/**
	 * 根据对象查询
	 * @param brokers
	 * @return List
	 */
	public List<Brokers> find(Brokers brokers){
		return brokersDao.find(brokers);
	}

	/**
	 * 根据对象查询
	 * @param brokers
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Brokers> find(Brokers brokers, Long offset, Long rows){
		return brokersDao.find(brokers, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param brokers
	 * @return Long
	 */
	public Long count(Brokers brokers){
		return brokersDao.count(brokers);
	}
}