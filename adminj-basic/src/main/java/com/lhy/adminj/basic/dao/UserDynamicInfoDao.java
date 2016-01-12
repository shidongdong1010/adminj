package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.UserDynamicInfoBaseDao;
import com.lhy.adminj.basic.model.UserDynamicInfo;

/**
 * 用户动态表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicInfoDao extends UserDynamicInfoBaseDao {

	/**
	 *  根据条件查询条数
	 * @param userName
	 * @param groupName
	 * @param type
	 * @return
	 */
	public Long orderCount(String userName, String groupName, String type,String auditStatus, String isInput);

	/**
	 * 根据条件查询
	 * @param userName
	 * @param groupName
	 * @param type
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Map<String, Object>> find(String userName, String groupName, String type,String auditStatus, String isInput,
										  Long offset, Long rows);

	/**
	 * 根据条件查询动态信息记录数
	 * @param userName
	 * @param type
	 * @param auditStatus
	 * @param createDateStart
	 * @param createDateEnd
	 * @return
	 */
	public Long count(String userName, String type, String auditStatus,
					  String createDateStart, String createDateEnd,String is_del, String isInput);

	/**
	 * 根据条件查询动态信息列表
	 * @param userName
	 * @param type
	 * @param auditStatus
	 * @param createDateStart
	 * @param createDateEnd
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<Map<String, Object>> find(String userName, String type,
										  String auditStatus, String createDateStart, String createDateEnd,String is_del,
			String isInput, Long offset, Long rows);
}
