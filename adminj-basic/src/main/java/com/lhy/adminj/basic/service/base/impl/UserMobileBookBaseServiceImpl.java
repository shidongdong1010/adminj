package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserMobileBookBaseService;
import com.lhy.adminj.basic.dao.UserMobileBookDao;

import com.lhy.adminj.basic.model.UserMobileBook;

/**
 * 用户手机通讯表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMobileBookBaseServiceImpl implements UserMobileBookBaseService{
	@Autowired
	protected UserMobileBookDao userMobileBookDao;

	@Override
	public void save(UserMobileBook userMobileBook) {
		userMobileBookDao.save(userMobileBook);
	}
	
	@Override
	public void update(UserMobileBook userMobileBook) {
		userMobileBookDao.update(userMobileBook);
	}

	@Override
	public void modify(UserMobileBook userMobileBook) {
		userMobileBookDao.modify(userMobileBook);
	}

	@Override
	public void delete(Long bookId){
		userMobileBookDao.delete(bookId);
	}

	@Override
	public void batchSave(List<UserMobileBook> list){
		userMobileBookDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserMobileBook> list){
		userMobileBookDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userMobileBookDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param bookId 通讯录ID
	 * @return UserMobileBook
	 */
	public UserMobileBook findById(Long bookId){
		return userMobileBookDao.findById(bookId);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook){
		return userMobileBookDao.find(userMobileBook);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders){
		return userMobileBookDao.find(userMobileBook, orders);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, Long offset, Long rows){
		return userMobileBookDao.find(userMobileBook, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders, Long offset, Long rows){
    	return userMobileBookDao.find(userMobileBook, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userMobileBook
	 * @return Long
	 */
	public Long count(UserMobileBook userMobileBook){
		return userMobileBookDao.count(userMobileBook);
	}
}