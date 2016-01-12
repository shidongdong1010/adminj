package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UserFeedBackInfoBaseDao;
import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserFeedBackInfoDao extends UserFeedBackInfoBaseDao {

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
	
	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFeedBackInfo> findList(UserFeedBackInfo userFeedBackInfo, Long offset, Long rows);
	
}
