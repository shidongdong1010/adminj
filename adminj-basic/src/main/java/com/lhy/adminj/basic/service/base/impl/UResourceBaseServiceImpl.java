package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UResourceBaseService;
import com.lhy.adminj.basic.dao.UResourceDao;

import com.lhy.adminj.basic.model.UResource;

/**
 * Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UResourceBaseServiceImpl implements UResourceBaseService{
	@Autowired
	protected UResourceDao uResourceDao;

	@Override
	public void save(UResource uResource) {
		uResourceDao.save(uResource);
	}
	
	@Override
	public void update(UResource uResource) {
		uResourceDao.update(uResource);
	}

	@Override
	public void modify(UResource uResource) {
		uResourceDao.modify(uResource);
	}

	@Override
	public void delete(Long id){
		uResourceDao.delete(id);
	}

	@Override
	public void batchSave(List<UResource> list){
		uResourceDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UResource> list){
		uResourceDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uResourceDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return UResource
	 */
	public UResource findById(Long id){
		return uResourceDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @return List
	 */
	public List<UResource> find(UResource uResource){
		return uResourceDao.find(uResource);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UResource> find(UResource uResource, String[][] orders){
		return uResourceDao.find(uResource, orders);
	}

	/**
	 * 根据对象查询
	 * @param uResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UResource> find(UResource uResource, Long offset, Long rows){
		return uResourceDao.find(uResource, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UResource> find(UResource uResource, String[][] orders, Long offset, Long rows){
    	return uResourceDao.find(uResource, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uResource
	 * @return Long
	 */
	public Long count(UResource uResource){
		return uResourceDao.count(uResource);
	}
}