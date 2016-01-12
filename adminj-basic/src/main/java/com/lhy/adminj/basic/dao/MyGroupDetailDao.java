package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.MyGroupDetailBaseDao;
import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupDetailDao extends MyGroupDetailBaseDao {

	/**
	 * 查询组合明细及股票的当前价
	 * @param groupId
	 * @return
	 */
	List<Map<String,Object>> findAndCurrPrice(Long groupId);
}
