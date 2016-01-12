package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.UserBaseDao;
import com.lhy.adminj.basic.model.User;

/**
 * 用户表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDao extends UserBaseDao {

	/**
	 * 根据对象查询支持用户名模糊查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	List<User> findLikeName(User user, String[][] orders, Long offset, Long rows);

	/**
	 * 注册数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	List<Map<String, Object>> registMonthCount(Integer year);
}
