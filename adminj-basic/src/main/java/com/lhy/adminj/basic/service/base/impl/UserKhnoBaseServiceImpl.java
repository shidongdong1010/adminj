package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserKhnoBaseService;
import com.lhy.adminj.basic.dao.UserKhnoDao;

import com.lhy.adminj.basic.model.UserKhno;

/**
 * 用户卷商表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserKhnoBaseServiceImpl implements UserKhnoBaseService{
	@Autowired
	protected UserKhnoDao userKhnoDao;

	@Override
	public void save(UserKhno userKhno) {
		userKhnoDao.save(userKhno);
	}
	
	@Override
	public void update(UserKhno userKhno) {
		userKhnoDao.update(userKhno);
	}

	@Override
	public void modify(UserKhno userKhno) {
		userKhnoDao.modify(userKhno);
	}

	@Override
	public void delete(Long id){
		userKhnoDao.delete(id);
	}

	@Override
	public void batchSave(List<UserKhno> list){
		userKhnoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserKhno> list){
		userKhnoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userKhnoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id ID
	 * @return UserKhno
	 */
	public UserKhno findById(Long id){
		return userKhnoDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno){
		return userKhnoDao.find(userKhno);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, String[][] orders){
		return userKhnoDao.find(userKhno, orders);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, Long offset, Long rows){
		return userKhnoDao.find(userKhno, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, String[][] orders, Long offset, Long rows){
    	return userKhnoDao.find(userKhno, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userKhno
	 * @return Long
	 */
	public Long count(UserKhno userKhno){
		return userKhnoDao.count(userKhno);
	}
}