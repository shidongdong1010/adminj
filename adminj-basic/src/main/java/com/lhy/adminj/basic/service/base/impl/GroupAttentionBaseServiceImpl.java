package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.GroupAttentionBaseService;
import com.lhy.adminj.basic.dao.GroupAttentionDao;

import com.lhy.adminj.basic.model.GroupAttention;

/**
 * 我关注的组合Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class GroupAttentionBaseServiceImpl implements GroupAttentionBaseService{
	@Autowired
	protected GroupAttentionDao groupAttentionDao;

	@Override
	public void save(GroupAttention groupAttention) {
		groupAttentionDao.save(groupAttention);
	}
	
	@Override
	public void update(GroupAttention groupAttention) {
		groupAttentionDao.update(groupAttention);
	}

	@Override
	public void modify(GroupAttention groupAttention) {
		groupAttentionDao.modify(groupAttention);
	}

	@Override
	public void delete(Long attentionId){
		groupAttentionDao.delete(attentionId);
	}

	@Override
	public void batchSave(List<GroupAttention> list){
		groupAttentionDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<GroupAttention> list){
		groupAttentionDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		groupAttentionDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return GroupAttention
	 */
	public GroupAttention findById(Long attentionId){
		return groupAttentionDao.findById(attentionId);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention){
		return groupAttentionDao.find(groupAttention);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders){
		return groupAttentionDao.find(groupAttention, orders);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, Long offset, Long rows){
		return groupAttentionDao.find(groupAttention, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders, Long offset, Long rows){
    	return groupAttentionDao.find(groupAttention, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param groupAttention
	 * @return Long
	 */
	public Long count(GroupAttention groupAttention){
		return groupAttentionDao.count(groupAttention);
	}
}