package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.service.base.MyGroupDetailBaseService;
import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupDetailService extends MyGroupDetailBaseService {

	/**
	 * 查询组合明细及股票的当前价
	 * @param groupId
	 * @return
	 */
	List<Map<String,Object>> findAndCurrPrice(Long groupId);
}
