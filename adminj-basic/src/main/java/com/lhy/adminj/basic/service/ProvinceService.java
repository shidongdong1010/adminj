package com.lhy.adminj.basic.service;

import com.lhy.adminj.basic.service.base.ProvinceBaseService;

/**
 * 省份表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ProvinceService extends ProvinceBaseService {

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
	/**
	 * 根据id数组删除信息
	 * @param provinceIds
	 */
	public void delete(String[] provinceIds);
}
