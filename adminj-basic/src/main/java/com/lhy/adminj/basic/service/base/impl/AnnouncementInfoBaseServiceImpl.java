package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.AnnouncementInfoBaseService;
import com.lhy.adminj.basic.dao.AnnouncementInfoDao;

import com.lhy.adminj.basic.model.AnnouncementInfo;

/**
 * 公告信息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AnnouncementInfoBaseServiceImpl implements AnnouncementInfoBaseService{
	@Autowired
	protected AnnouncementInfoDao announcementInfoDao;

	@Override
	public void save(AnnouncementInfo announcementInfo) {
		announcementInfoDao.save(announcementInfo);
	}
	
	@Override
	public void update(AnnouncementInfo announcementInfo) {
		announcementInfoDao.update(announcementInfo);
	}

	@Override
	public void modify(AnnouncementInfo announcementInfo) {
		announcementInfoDao.modify(announcementInfo);
	}

	@Override
	public void delete(Long announcementId){
		announcementInfoDao.delete(announcementId);
	}

	@Override
	public void batchSave(List<AnnouncementInfo> list){
		announcementInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<AnnouncementInfo> list){
		announcementInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		announcementInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param announcementId 公告信息ID
	 * @return AnnouncementInfo
	 */
	public AnnouncementInfo findById(Long announcementId){
		return announcementInfoDao.findById(announcementId);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo){
		return announcementInfoDao.find(announcementInfo);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders){
		return announcementInfoDao.find(announcementInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, Long offset, Long rows){
		return announcementInfoDao.find(announcementInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders, Long offset, Long rows){
    	return announcementInfoDao.find(announcementInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param announcementInfo
	 * @return Long
	 */
	public Long count(AnnouncementInfo announcementInfo){
		return announcementInfoDao.count(announcementInfo);
	}
}