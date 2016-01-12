package com.lhy.adminj.basic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhy.adminj.basic.enumeration.UUserIsExpiredEnum;
import com.lhy.adminj.basic.enumeration.UUserIsLockedEnum;
import com.lhy.adminj.basic.model.UUserRole;
import com.lhy.adminj.basic.service.base.impl.UUserBaseServiceImpl;

import com.lhy.adminj.basic.util.password.PasswordUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UUser;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Transactional
@Service
public class UUserServiceImpl extends UUserBaseServiceImpl implements UUserService {

	@Autowired
	private UUserRoleService uUserRoleService;

	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public UUser findByUserName(String userName){
		return uUserDao.findByUserName(userName);
	}

	/**
	 * 添加用户
	 * @param user
	 * @param roleIds
	 */
	@Transactional(propagation = Propagation.REQUIRED, timeout = 10, rollbackFor = Exception.class)
	public void addUser(UUser user, Long[] roleIds){
		// TODO 添加操作日志, 用户角色关系补充（生效时间，失效时间, 状态）
		// 保存用户
		user.setPassword(PasswordUtil.encode(user.getPassword()));
		user.setIsExpired(UUserIsExpiredEnum.N.getCode());
		save(user);

		// 保存用户的角色
		for(Long roleId : roleIds){
			UUserRole uUserRole = new UUserRole();
			uUserRole.setRoleId(roleId);
			uUserRole.setUserId(user.getId());
			uUserRoleService.save(uUserRole);
		}
	}

	/**
	 * 修改用户
	 * @param user
	 * @param roleIds
	 */
	@Transactional(propagation = Propagation.REQUIRED, timeout = 10, rollbackFor = Exception.class)
	public void updateUser(UUser user, Long[] roleIds){
		// TODO 添加操作日志, 用户角色关系补充（生效时间，失效时间, 状态）
		UUser uUser = findById(user.getId());
		if(uUser == null) return;
		user.setPassword(uUser.getPassword());
		user.setIsExpired(uUser.getIsExpired());
		// 修改用户
		update(user);

		// 查询出用户的角色
		List<UUserRole> uUserRoles = uUserRoleService.findByUserId(user.getId());

		// 原有的角色ID
		List<Long> oldRoleIdList = new ArrayList<Long>();

		// 删除没有的角色
		for(UUserRole uUserRole: uUserRoles){
			if(!ArrayUtils.contains(roleIds, uUserRole.getRoleId())){
				// 不包含, 删除
				uUserRoleService.delete(uUserRole.getId());
			}
			oldRoleIdList.add(uUserRole.getRoleId());
		}

		// 将原角色ID转为数组
		Long[] oldRoleIds = new Long[oldRoleIdList.size()];
		oldRoleIdList.toArray(oldRoleIds);

		// 保存新的角色
		for(Long roleId : roleIds){
			if(!ArrayUtils.contains(oldRoleIds, roleId)) {
				// 不包含，添加
				UUserRole uUserRole = new UUserRole();
				uUserRole.setRoleId(roleId);
				uUserRole.setUserId(user.getId());
				uUserRoleService.save(uUserRole);
			}
		}
	}

	/**
	 * 重置登陆错误的次数为0
	 * @param userName
	 */
	public void resetFailAttempts(String userName){
		UUser user = findByUserName(userName);
		if(user != null && user.getId() != null) {
			user.setLoginErrorCount(0L);
			user.setLastLoginTime(new Date());
			update(user);
		}
	}

	/**
	 * 更新登陆错误的次数+1
	 * @param userName
	 */
	public UUser updateFailAttempts(String userName) {
		UUser user = findByUserName(userName);
		if(user != null && user.getId() != null) {
			Long errorCount = user.getLoginErrorCount() == null ? 0 : user.getLoginErrorCount() ;
			user.setLoginErrorCount(errorCount + 1);
			user.setLastLoginTime(new Date());

			if(user.getLoginErrorCount() >= MAX_ATTEMPTS){
				user.setIsLocked(UUserIsLockedEnum.LOCKED.getCode());
			}
			update(user);
		}
		return user;
	}


	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplateClsp;

	@Transactional(propagation = Propagation.REQUIRED, timeout = 10, rollbackFor = Exception.class)
	public void testJta(){
		jdbcTemplate.update("update u_user set mobile = '123' where id = 3");
		jdbcTemplateClsp.update("update u_user set tele_num = 123 where user_id = 820");
		jdbcTemplateClsp.update("update CCARD_APP_DATA set IS_DEAL = '2' where SD_APP_SEQ = 'JN201512150002'");
	}
}
