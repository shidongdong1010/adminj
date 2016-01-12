package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.model.City;
import com.lhy.adminj.basic.service.base.impl.CityBaseServiceImpl;

/**
 * 城市表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class CityServiceImpl extends CityBaseServiceImpl implements CityService {

	@Override
	public void delete(String[] cityIds) {
		cityDao.delete(cityIds);
		
	}
	@Override
	public List<Map<String, Object>> findCity(City city, Long offset, Long rows){
		return cityDao.findCity(city, offset, rows);
	}
}
