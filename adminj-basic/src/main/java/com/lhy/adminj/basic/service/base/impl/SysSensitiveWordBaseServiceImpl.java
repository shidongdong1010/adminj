package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.SysSensitiveWordBaseService;
import com.lhy.adminj.basic.dao.SysSensitiveWordDao;

import com.lhy.adminj.basic.model.SysSensitiveWord;

/**
 * 敏感词库Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSensitiveWordBaseServiceImpl implements SysSensitiveWordBaseService{
	@Autowired
	protected SysSensitiveWordDao sysSensitiveWordDao;

	@Override
	public void save(SysSensitiveWord sysSensitiveWord) {
		sysSensitiveWordDao.save(sysSensitiveWord);
	}
	
	@Override
	public void update(SysSensitiveWord sysSensitiveWord) {
		sysSensitiveWordDao.update(sysSensitiveWord);
	}

	@Override
	public void modify(SysSensitiveWord sysSensitiveWord) {
		sysSensitiveWordDao.modify(sysSensitiveWord);
	}

	@Override
	public void delete(Long wordId){
		sysSensitiveWordDao.delete(wordId);
	}

	@Override
	public void batchSave(List<SysSensitiveWord> list){
		sysSensitiveWordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<SysSensitiveWord> list){
		sysSensitiveWordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		sysSensitiveWordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param wordId 敏感词ID
	 * @return SysSensitiveWord
	 */
	public SysSensitiveWord findById(Long wordId){
		return sysSensitiveWordDao.findById(wordId);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord){
		return sysSensitiveWordDao.find(sysSensitiveWord);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders){
		return sysSensitiveWordDao.find(sysSensitiveWord, orders);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, Long offset, Long rows){
		return sysSensitiveWordDao.find(sysSensitiveWord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders, Long offset, Long rows){
    	return sysSensitiveWordDao.find(sysSensitiveWord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param sysSensitiveWord
	 * @return Long
	 */
	public Long count(SysSensitiveWord sysSensitiveWord){
		return sysSensitiveWordDao.count(sysSensitiveWord);
	}
}