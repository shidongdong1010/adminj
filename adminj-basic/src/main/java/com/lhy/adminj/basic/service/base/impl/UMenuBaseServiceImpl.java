package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UMenuBaseService;
import com.lhy.adminj.basic.dao.UMenuDao;

import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UMenuBaseServiceImpl implements UMenuBaseService{
	@Autowired
	protected UMenuDao uMenuDao;

	@Override
	public void save(UMenu uMenu) {
		uMenuDao.save(uMenu);
	}
	
	@Override
	public void update(UMenu uMenu) {
		uMenuDao.update(uMenu);
	}

	@Override
	public void modify(UMenu uMenu) {
		uMenuDao.modify(uMenu);
	}

	@Override
	public void delete(Long id){
		uMenuDao.delete(id);
	}

	@Override
	public void batchSave(List<UMenu> list){
		uMenuDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UMenu> list){
		uMenuDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uMenuDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UMenu
	 */
	public UMenu findById(Long id){
		return uMenuDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu){
		return uMenuDao.find(uMenu);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, String[][] orders){
		return uMenuDao.find(uMenu, orders);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, Long offset, Long rows){
		return uMenuDao.find(uMenu, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, String[][] orders, Long offset, Long rows){
    	return uMenuDao.find(uMenu, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uMenu
	 * @return Long
	 */
	public Long count(UMenu uMenu){
		return uMenuDao.count(uMenu);
	}
}