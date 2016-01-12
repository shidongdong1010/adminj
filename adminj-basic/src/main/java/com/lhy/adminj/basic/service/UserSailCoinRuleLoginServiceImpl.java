package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UserSailCoinRuleLoginBaseServiceImpl;
import com.lhy.adminj.basic.service.UserSailCoinRuleLoginService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserSailCoinRuleLoginServiceImpl extends UserSailCoinRuleLoginBaseServiceImpl implements UserSailCoinRuleLoginService {

	@Override
	public void updateCoin() {
		userSailCoinRuleLoginDao.updateCoin();
	}

	@Override
	public List<UserSailCoinRuleLogin> findAll() {
		// TODO Auto-generated method stub
		return userSailCoinRuleLoginDao.findAll();
	}

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
}
