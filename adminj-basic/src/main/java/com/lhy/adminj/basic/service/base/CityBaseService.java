package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.City;

/**
 * 城市表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CityBaseService {

	public void save(City city);
	
	public void update(City city);

	public void modify(City city);

	public void delete(Long cityId);

	public void batchSave(List<City> list);

    public void batchUpdate(List<City> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param cityId 城市ID
	 * @return City
	 */
	public City findById(Long cityId);

	/**
	 * 根据对象查询
	 * @param city
	 * @return List
	 */
	public List<City> find(City city);

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<City> find(City city, String[][] orders);

	/**
	 * 根据对象查询
	 * @param city
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<City> find(City city, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<City> find(City city, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param city
	 * @return Long
	 */
	public Long count(City city);
}
