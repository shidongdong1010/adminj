package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.SysDefaultSettingBaseService;
import com.lhy.adminj.basic.dao.SysDefaultSettingDao;

import com.lhy.adminj.basic.model.SysDefaultSetting;

/**
 * 默认值设置表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysDefaultSettingBaseServiceImpl implements SysDefaultSettingBaseService{
	@Autowired
	protected SysDefaultSettingDao sysDefaultSettingDao;

	@Override
	public void save(SysDefaultSetting sysDefaultSetting) {
		sysDefaultSettingDao.save(sysDefaultSetting);
	}
	
	@Override
	public void update(SysDefaultSetting sysDefaultSetting) {
		sysDefaultSettingDao.update(sysDefaultSetting);
	}

	@Override
	public void modify(SysDefaultSetting sysDefaultSetting) {
		sysDefaultSettingDao.modify(sysDefaultSetting);
	}

	@Override
	public void delete(String code){
		sysDefaultSettingDao.delete(code);
	}

	@Override
	public void batchSave(List<SysDefaultSetting> list){
		sysDefaultSettingDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<SysDefaultSetting> list){
		sysDefaultSettingDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		sysDefaultSettingDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param code 代码
	 * @return SysDefaultSetting
	 */
	public SysDefaultSetting findById(String code){
		return sysDefaultSettingDao.findById(code);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting){
		return sysDefaultSettingDao.find(sysDefaultSetting);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders){
		return sysDefaultSettingDao.find(sysDefaultSetting, orders);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, Long offset, Long rows){
		return sysDefaultSettingDao.find(sysDefaultSetting, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders, Long offset, Long rows){
    	return sysDefaultSettingDao.find(sysDefaultSetting, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param sysDefaultSetting
	 * @return Long
	 */
	public Long count(SysDefaultSetting sysDefaultSetting){
		return sysDefaultSettingDao.count(sysDefaultSetting);
	}
}