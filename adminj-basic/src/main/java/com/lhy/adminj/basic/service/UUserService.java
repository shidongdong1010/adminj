package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.UUserBaseService;
import com.lhy.adminj.basic.model.UUser;
import org.springframework.security.authentication.LockedException;

/**
 * 用户表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UUserService extends UUserBaseService {

	// 最大登陆错误次数
	public static final int MAX_ATTEMPTS = 5;

	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public UUser findByUserName(String userName);

	/**
	 * 添加用户
	 * @param user 添加的用户信息
	 * @param roleIds 角色ID数组
	 */
	public void addUser(UUser user, Long[] roleIds);

	/**
	 * 修改用户
	 * @param user 添加的用户信息
	 * @param roleIds 角色ID数组
	 */
	public void updateUser(UUser user, Long[] roleIds);

	/**
	 * 重置登陆错误的次数为0
	 * @param userName
	 */
	public void resetFailAttempts(String userName);

	/**
	 * 更新登陆错误的次数+1
	 * @param userName
	 */
	public UUser updateFailAttempts(String userName);

	public void testJta();
}
