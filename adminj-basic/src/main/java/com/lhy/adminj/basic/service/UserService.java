package com.lhy.adminj.basic.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.model.User;
import com.lhy.adminj.basic.model.UserBacklist;
import com.lhy.adminj.basic.model.UserDetail;
import com.lhy.adminj.basic.model.UserStatRecord;
import com.lhy.adminj.basic.service.base.UserBaseService;

/**
 * 用户表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserService extends UserBaseService {

	/**
	 * 根据对象查询支持用户名模糊查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	List<User> findLikeName(User user, String[][] orders,Long offset, Long rows);

	/**
	 * 添加用户
	 * @param user 用户信息
	 * @param userDetail 用户详细信息
	 * @param userStatRecord 用户统计信息
	 * @param userBacklist 用户黑名单信息
	 * @param imgFileIs 用户头像文件输入流
	 */
	void addUser(User user,UserDetail userDetail,UserStatRecord userStatRecord,UserBacklist userBacklist,InputStream imgFileIs);

	/**
	 * 修改用户
	 * @param userId
	 * @return
	 */
	Map<String, Object> editUser(Long userId);

	/**
	 * 保存用户信息
	 * @param user
	 * @param userDetail
	 * @param userStatRecord
	 * @param userBacklist
	 * @param imgFileIs
	 */
	void saveUser(User user, UserDetail userDetail,
			UserStatRecord userStatRecord, UserBacklist userBacklist,
			InputStream imgFileIs);

	/**
	 * 注册数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	List<Map<String, Object>> registMonthCount(Integer year);

}
