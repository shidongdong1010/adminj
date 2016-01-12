package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.CityBaseService;
import com.lhy.adminj.basic.dao.CityDao;

import com.lhy.adminj.basic.model.City;

/**
 * 城市表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CityBaseServiceImpl implements CityBaseService{
	@Autowired
	protected CityDao cityDao;

	@Override
	public void save(City city) {
		cityDao.save(city);
	}
	
	@Override
	public void update(City city) {
		cityDao.update(city);
	}

	@Override
	public void modify(City city) {
		cityDao.modify(city);
	}

	@Override
	public void delete(Long cityId){
		cityDao.delete(cityId);
	}

	@Override
	public void batchSave(List<City> list){
		cityDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<City> list){
		cityDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		cityDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param cityId 城市ID
	 * @return City
	 */
	public City findById(Long cityId){
		return cityDao.findById(cityId);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @return List
	 */
	public List<City> find(City city){
		return cityDao.find(city);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<City> find(City city, String[][] orders){
		return cityDao.find(city, orders);
	}

	/**
	 * 根据对象查询
	 * @param city
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<City> find(City city, Long offset, Long rows){
		return cityDao.find(city, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<City> find(City city, String[][] orders, Long offset, Long rows){
    	return cityDao.find(city, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param city
	 * @return Long
	 */
	public Long count(City city){
		return cityDao.count(city);
	}
}