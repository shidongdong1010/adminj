package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.AdvertisingInfoBaseService;
import com.lhy.adminj.basic.dao.AdvertisingInfoDao;

import com.lhy.adminj.basic.model.AdvertisingInfo;

/**
 * 广告信息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AdvertisingInfoBaseServiceImpl implements AdvertisingInfoBaseService{
	@Autowired
	protected AdvertisingInfoDao advertisingInfoDao;

	@Override
	public void save(AdvertisingInfo advertisingInfo) {
		advertisingInfoDao.save(advertisingInfo);
	}
	
	@Override
	public void update(AdvertisingInfo advertisingInfo) {
		advertisingInfoDao.update(advertisingInfo);
	}

	@Override
	public void modify(AdvertisingInfo advertisingInfo) {
		advertisingInfoDao.modify(advertisingInfo);
	}

	@Override
	public void delete(Long advertisingId){
		advertisingInfoDao.delete(advertisingId);
	}

	@Override
	public void batchSave(List<AdvertisingInfo> list){
		advertisingInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<AdvertisingInfo> list){
		advertisingInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		advertisingInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param advertisingId 广告信息ID
	 * @return AdvertisingInfo
	 */
	public AdvertisingInfo findById(Long advertisingId){
		return advertisingInfoDao.findById(advertisingId);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo){
		return advertisingInfoDao.find(advertisingInfo);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders){
		return advertisingInfoDao.find(advertisingInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, Long offset, Long rows){
		return advertisingInfoDao.find(advertisingInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders, Long offset, Long rows){
    	return advertisingInfoDao.find(advertisingInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param advertisingInfo
	 * @return Long
	 */
	public Long count(AdvertisingInfo advertisingInfo){
		return advertisingInfoDao.count(advertisingInfo);
	}
}