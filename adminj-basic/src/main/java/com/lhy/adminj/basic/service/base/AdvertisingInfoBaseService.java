package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.AdvertisingInfo;

/**
 * 广告信息表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface AdvertisingInfoBaseService {

	public void save(AdvertisingInfo advertisingInfo);
	
	public void update(AdvertisingInfo advertisingInfo);

	public void modify(AdvertisingInfo advertisingInfo);

	public void delete(Long advertisingId);

	public void batchSave(List<AdvertisingInfo> list);

    public void batchUpdate(List<AdvertisingInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param advertisingId 广告信息ID
	 * @return AdvertisingInfo
	 */
	public AdvertisingInfo findById(Long advertisingId);

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo);

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param advertisingInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param advertisingInfo
	 * @return Long
	 */
	public Long count(AdvertisingInfo advertisingInfo);
}
