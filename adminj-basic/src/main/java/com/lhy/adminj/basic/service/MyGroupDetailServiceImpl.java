package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.service.base.impl.MyGroupDetailBaseServiceImpl;
import com.lhy.adminj.basic.service.MyGroupDetailService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class MyGroupDetailServiceImpl extends MyGroupDetailBaseServiceImpl implements MyGroupDetailService {

	/**
	 * 查询组合明细及股票的当前价
	 * @param groupId
	 * @return
	 */
	public List<Map<String,Object>> findAndCurrPrice(Long groupId){
		return myGroupDetailDao.findAndCurrPrice(groupId);
	}
}
