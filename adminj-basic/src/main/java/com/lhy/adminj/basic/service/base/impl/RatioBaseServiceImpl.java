package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.RatioBaseService;
import com.lhy.adminj.basic.dao.RatioDao;

import com.lhy.adminj.basic.model.Ratio;

/**
 * 浮动表(涨幅、跌幅、换手率、振幅榜)Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class RatioBaseServiceImpl implements RatioBaseService{
	@Autowired
	protected RatioDao ratioDao;

	@Override
	public void save(Ratio ratio) {
		ratioDao.save(ratio);
	}
	
	@Override
	public void update(Ratio ratio) {
		ratioDao.update(ratio);
	}

	@Override
	public void delete(Long ratioId){
		ratioDao.delete(ratioId);
	}

	/**
	 * 根据主键查询
	 * @param ratioId 浮动表主键
	 * @return Ratio
	 */
	public Ratio findById(Long ratioId){
		return ratioDao.findById(ratioId);
	}

	/**
	 * 根据对象查询
	 * @param ratio
	 * @return List
	 */
	public List<Ratio> find(Ratio ratio){
		return ratioDao.find(ratio);
	}

	/**
	 * 根据对象查询
	 * @param ratio
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Ratio> find(Ratio ratio, Long offset, Long rows){
		return ratioDao.find(ratio, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param ratio
	 * @return Long
	 */
	public Long count(Ratio ratio){
		return ratioDao.count(ratio);
	}
}