package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserGeniusBaseService;
import com.lhy.adminj.basic.dao.UserGeniusDao;

import com.lhy.adminj.basic.model.UserGenius;

/**
 * 牛人排名记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserGeniusBaseServiceImpl implements UserGeniusBaseService{
	@Autowired
	protected UserGeniusDao userGeniusDao;

	@Override
	public void save(UserGenius userGenius) {
		userGeniusDao.save(userGenius);
	}
	
	@Override
	public void update(UserGenius userGenius) {
		userGeniusDao.update(userGenius);
	}

	@Override
	public void modify(UserGenius userGenius) {
		userGeniusDao.modify(userGenius);
	}

	@Override
	public void delete(Long geniusId){
		userGeniusDao.delete(geniusId);
	}

	@Override
	public void batchSave(List<UserGenius> list){
		userGeniusDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserGenius> list){
		userGeniusDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userGeniusDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param geniusId 牛人表主键ID
	 * @return UserGenius
	 */
	public UserGenius findById(Long geniusId){
		return userGeniusDao.findById(geniusId);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius){
		return userGeniusDao.find(userGenius);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, String[][] orders){
		return userGeniusDao.find(userGenius, orders);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, Long offset, Long rows){
		return userGeniusDao.find(userGenius, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, String[][] orders, Long offset, Long rows){
    	return userGeniusDao.find(userGenius, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userGenius
	 * @return Long
	 */
	public Long count(UserGenius userGenius){
		return userGeniusDao.count(userGenius);
	}
}