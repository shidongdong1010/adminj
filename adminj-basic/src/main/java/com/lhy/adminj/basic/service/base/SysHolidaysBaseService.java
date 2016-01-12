package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.SysHolidays;

/**
 * 节假日表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface SysHolidaysBaseService {

	public void save(SysHolidays sysHolidays);
	
	public void update(SysHolidays sysHolidays);

	public void modify(SysHolidays sysHolidays);

	public void delete(Long holidaysId);

	public void batchSave(List<SysHolidays> list);

    public void batchUpdate(List<SysHolidays> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param holidaysId 节假日ID
	 * @return SysHolidays
	 */
	public SysHolidays findById(Long holidaysId);

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays);

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders);

	/**
	 * 根据对象查询
	 * @param sysHolidays
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param sysHolidays
	 * @return Long
	 */
	public Long count(SysHolidays sysHolidays);
}
