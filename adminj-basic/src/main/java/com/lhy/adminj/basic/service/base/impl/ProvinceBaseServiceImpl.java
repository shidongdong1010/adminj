package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.ProvinceBaseService;
import com.lhy.adminj.basic.dao.ProvinceDao;

import com.lhy.adminj.basic.model.Province;

/**
 * 省份表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ProvinceBaseServiceImpl implements ProvinceBaseService{
	@Autowired
	protected ProvinceDao provinceDao;

	@Override
	public void save(Province province) {
		provinceDao.save(province);
	}
	
	@Override
	public void update(Province province) {
		provinceDao.update(province);
	}

	@Override
	public void modify(Province province) {
		provinceDao.modify(province);
	}

	@Override
	public void delete(Long provinceId){
		provinceDao.delete(provinceId);
	}

	@Override
	public void batchSave(List<Province> list){
		provinceDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<Province> list){
		provinceDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		provinceDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param provinceId 省份ID
	 * @return Province
	 */
	public Province findById(Long provinceId){
		return provinceDao.findById(provinceId);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @return List
	 */
	public List<Province> find(Province province){
		return provinceDao.find(province);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Province> find(Province province, String[][] orders){
		return provinceDao.find(province, orders);
	}

	/**
	 * 根据对象查询
	 * @param province
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Province> find(Province province, Long offset, Long rows){
		return provinceDao.find(province, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Province> find(Province province, String[][] orders, Long offset, Long rows){
    	return provinceDao.find(province, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param province
	 * @return Long
	 */
	public Long count(Province province){
		return provinceDao.count(province);
	}
}