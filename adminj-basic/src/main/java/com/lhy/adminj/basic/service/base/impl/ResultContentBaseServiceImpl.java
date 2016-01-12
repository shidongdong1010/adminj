package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.ResultContentBaseService;
import com.lhy.adminj.basic.dao.ResultContentDao;

import com.lhy.adminj.basic.model.ResultContent;

/**
 * 实时交易表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResultContentBaseServiceImpl implements ResultContentBaseService{
	@Autowired
	protected ResultContentDao resultContentDao;

	@Override
	public void save(ResultContent resultContent) {
		resultContentDao.save(resultContent);
	}
	
	@Override
	public void update(ResultContent resultContent) {
		resultContentDao.update(resultContent);
	}

	@Override
	public void delete(Long resultContentId){
		resultContentDao.delete(resultContentId);
	}

	/**
	 * 根据主键查询
	 * @param resultContentId 实时数据表主键
	 * @return ResultContent
	 */
	public ResultContent findById(Long resultContentId){
		return resultContentDao.findById(resultContentId);
	}

	/**
	 * 根据对象查询
	 * @param resultContent
	 * @return List
	 */
	public List<ResultContent> find(ResultContent resultContent){
		return resultContentDao.find(resultContent);
	}

	/**
	 * 根据对象查询
	 * @param resultContent
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<ResultContent> find(ResultContent resultContent, Long offset, Long rows){
		return resultContentDao.find(resultContent, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param resultContent
	 * @return Long
	 */
	public Long count(ResultContent resultContent){
		return resultContentDao.count(resultContent);
	}
}