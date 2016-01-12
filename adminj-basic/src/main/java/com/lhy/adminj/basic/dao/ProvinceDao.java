package com.lhy.adminj.basic.dao;

import com.lhy.adminj.basic.dao.base.ProvinceBaseDao;

/**
 * 省份表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ProvinceDao extends ProvinceBaseDao {

	/**
	 * 根据id删除
	 * @param provinceIds
	 */
	void delete(String[] provinceIds);

}
