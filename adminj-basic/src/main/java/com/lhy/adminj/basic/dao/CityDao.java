package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.CityBaseDao;
import com.lhy.adminj.basic.model.City;

/**
 * 城市表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CityDao extends CityBaseDao {

	/**
	 * 根据id删除
	 * @param cityIds
	 */
	void delete(String[] cityIds);

	/**
	 * 查询城市列表
	 * @param city
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<Map<String, Object>> findCity(City city, Long offset, Long rows);
}
