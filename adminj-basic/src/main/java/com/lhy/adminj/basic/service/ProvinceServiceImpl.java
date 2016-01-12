package com.lhy.adminj.basic.service;

import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.service.base.impl.ProvinceBaseServiceImpl;

/**
 * 省份表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class ProvinceServiceImpl extends ProvinceBaseServiceImpl implements ProvinceService {

	@Override
	public void delete(String[] provinceIds) {
		provinceDao.delete(provinceIds);
		
	}

}
