package com.lhy.adminj.basic.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.enumeration.*;
import com.lhy.adminj.basic.model.*;
import com.lhy.adminj.basic.service.base.impl.UserDynamicInfoBaseServiceImpl;
import com.lhy.adminj.basic.service.UserDynamicInfoService;

import com.lhy.adminj.basic.util.MathUtil;
import com.lhy.adminj.basic.util.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户动态表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Transactional
@Service
public class UserDynamicInfoServiceImpl extends UserDynamicInfoBaseServiceImpl implements UserDynamicInfoService {

	@Autowired
	private UserStockPositionService userStockPositionService;
	@Autowired
	private TradeService tradeService;
	@Autowired
	private UserService userService;
	@Autowired
	private MyGroupService myGroupService;
	@Autowired
	private MyGroupDetailService myGroupDetailService;
	@Autowired
	private UserStatRecordService userStatRecordService;

	/**
	 * 插入晒单信息的录入数据
	 *
	 * @param userDynamicInfo 晒单的动态信息
	 * @param trades 交易记录
	 * @param userId 用户ID
	 */
	@Override
	//@Transactional(propagation = Propagation.REQUIRED, timeout = 10, rollbackFor = Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addOrder(UserDynamicInfo userDynamicInfo, List<Trade> trades, Long userId, Long parentGroupId){
		// 查询用户的持仓
		UserStockPosition stockPositionParam = new UserStockPosition();
		stockPositionParam.setUserId(userId);
		List<UserStockPosition> stockPositions = userStockPositionService.find(stockPositionParam);

		// 得到我的组合
		MyGroup myGroup = this.getGroup(trades, userDynamicInfo, userId, parentGroupId);

		for(Trade trade : trades){
			trade.setGroupId(myGroup.getGroupId());
			tradeService.save(trade);

			boolean flag = false;
			for (UserStockPosition position : stockPositions){
				if(position.getStockCode().equals(trade.getStockCode())){
					flag = true;
					TradeTradeTypeEnum tradeTradeTypeEnum = TradeTradeTypeEnum.getByCode(trade.getTradeType());
					switch (tradeTradeTypeEnum) {
						case B:
							// 买入，增加持仓
							this.addUserStockPosition(myGroup, position, trade, true);
							break;
						case S:
							// 卖出，减少持仓
							this.addUserStockPosition(myGroup, position, trade, false);
 							break;
					}
				}
			}

			if(!flag) {
				// 没有持仓，则增加持仓
				createUserStockPosition(myGroup, trade, userId);
			}
		}

		// 更新组合
		myGroupService.update(myGroup);

		// 将此条记录修改成审批通过
		userDynamicInfo.setAuditDate(new java.util.Date());
		userDynamicInfo.setAuditName(AuthUtil.getUserName());
		userDynamicInfo.setIsInput(UserDynamicInfoIsInputEnum.Y.getCode());
		userDynamicInfo.setGroupId(myGroup.getGroupId());
		update(userDynamicInfo);
	}

	/**
	 * 创建持仓
	 * @param myGroup
	 * @param trade
	 * @param userId
	 * @return
	 */
	private UserStockPosition createUserStockPosition(MyGroup myGroup, Trade trade, Long userId){
		Long num = trade.getTradeNumber();
		Date currDate = new java.util.Date();

		MyGroupDetail myGroupDetail = new MyGroupDetail();
		myGroupDetail.setCreateDate(currDate);
		myGroupDetail.setUpdateDate(currDate);
		myGroupDetail.setGroupId(myGroup.getGroupId());
		myGroupDetail.setIsDel(MyGroupDetailIsDelEnum.N.getCode());
		// 新增持仓
		myGroupDetail.setStockCode(trade.getStockCode());
		myGroupDetail.setStockId(trade.getStockId());
		myGroupDetail.setStockName(trade.getStockName());
		myGroupDetail.setTodayTradeIncome(0d);
		myGroupDetail.setTotalTradeIncome(0d);
		myGroupDetail.setTotalCost(trade.getTurnoverAmount());
		myGroupDetailService.save(myGroupDetail);

		UserStockPosition userStockPosition = new UserStockPosition();
		userStockPosition.setUserId(userId);
		userStockPosition.setGroupId(myGroup.getGroupId());
		userStockPosition.setGroupDetailId(myGroupDetail.getGroupDetailId());
		userStockPosition.setStockId(trade.getStockId());
		userStockPosition.setStockCode(trade.getStockCode());
		userStockPosition.setStockName(trade.getStockName());
		userStockPosition.setStockNum(num);
		userStockPosition.setSellNum(num);
		userStockPosition.setCurrency(UserStockPositionCurrencyEnum.CNY.getCode());
		userStockPosition.setStockNum(num);
		userStockPosition.setCostPrice(trade.getTradePrice());
		userStockPosition.setProfitLoss(0d);
		userStockPosition.setProfitLossRatio(0d);
		userStockPosition.setCurrPrice(0d);
		userStockPosition.setTodayBuyNum(num);
		userStockPosition.setTodaySellNum(0l);
		userStockPosition.setCostAmount(trade.getTurnoverAmount());
		userStockPosition.setCreateDate(currDate);
		userStockPosition.setUpdateDate(currDate);
		userStockPosition.setIsDel(UserStockPositionIsDelEnum.N.getCode());
		userStockPositionService.save(userStockPosition);
		return userStockPosition;
	}

	/**
	 * 修改持仓
	 * @param trade
	 * @return
	 */
	private UserStockPosition addUserStockPosition(MyGroup myGroup, UserStockPosition userStockPosition, Trade trade, boolean isAdd){
		// 交易数量
		Long num = trade.getTradeNumber();
		// 成交价
		Double tradePrice = trade.getTradePrice();
		// 交易金额
		Double turnoverAmount = trade.getTurnoverAmount();

		if(!isAdd){
			num = -num;
			turnoverAmount = -turnoverAmount;
			tradePrice = -tradePrice;
		}
		Date currDate = new java.util.Date();
		// 查询我的组合明细
		MyGroupDetail myGroupDetail = myGroupDetailService.findById(userStockPosition.getGroupDetailId());
		myGroupDetail.setUpdateDate(currDate);

		Double todayTradeIncome = 0d;
		// 日收入
		if(!isAdd) {
			// 只有买股票时计算日收入
			todayTradeIncome =  MathUtil.div(MathUtil.sub(tradePrice, userStockPosition.getCostPrice()), trade.getTradeNumber(), 4);
		}
		myGroupDetail.setTodayTradeIncome(MathUtil.add(myGroupDetail.getTodayTradeIncome(),todayTradeIncome));

		// 总收入
		myGroupDetail.setTotalTradeIncome(0d);
		// 总成本
		myGroupDetail.setTotalCost(MathUtil.add(myGroupDetail.getTotalCost(), turnoverAmount));
		myGroupDetailService.update(myGroupDetail);

		// 比较今日收入是否盈利
		if (todayTradeIncome.compareTo(0d) == 1) {// 交易盈利次数
			myGroup.setProfitCount(myGroup.getProfitCount() + 1);
		}
		else if (todayTradeIncome.compareTo(0d) == -1) {// 交易亏损次数
			myGroup.setLossCount(myGroup.getLossCount() + 1);
		}

		// 股票数
		userStockPosition.setStockNum(userStockPosition.getStockNum() + num);
		// 可卖数
		userStockPosition.setSellNum(userStockPosition.getSellNum() + num);
		// 成本价
		if(userStockPosition.getStockNum() >  0) {
			userStockPosition.setCostPrice(MathUtil.div(MathUtil.add(userStockPosition.getCostPrice(), trade.getTurnoverAmount()), userStockPosition.getStockNum(), 4));
		}else{
			userStockPosition.setCostPrice(0d);
		}
		// 成本金额
		userStockPosition.setCostAmount(MathUtil.add(userStockPosition.getCostAmount(), turnoverAmount));

		if(isAdd) {
			userStockPosition.setTodayBuyNum(userStockPosition.getTodayBuyNum() + num);		// 今买数量
			userStockPosition.setTodaySellNum(0l);
		}else{
			userStockPosition.setTodayBuyNum(0l);
			userStockPosition.setTodaySellNum(userStockPosition.getTodaySellNum() + num);	// 今卖数量
		}

		userStockPosition.setIsDel(UserStockPositionIsDelEnum.Y.getCode());
		userStockPosition.setUpdateDate(currDate);
		userStockPositionService.update(userStockPosition);
		return userStockPosition;
	}

	/**
	 * 得到组合
	 * @param userDynamicInfo
	 * @param userId
	 * @return
	 */
	private MyGroup getGroup(List<Trade> trades, UserDynamicInfo userDynamicInfo, Long userId, Long parentGroupId){
		// 计算总成本
		Double totalCost = 0d;
		for (Trade trade : trades) {
			totalCost = MathUtil.add(totalCost, trade.getTurnoverAmount());
		}

		// 查询组合
		MyGroup param = new MyGroup();
		param.setUserId(userId);
		List<MyGroup> groups = myGroupService.find(param);
		MyGroup group = null;
		if(groups != null && groups.size() > 0) {
			group = groups.get(0);
			// 更新我的组合交易数量
			group.setTradeCount(group.getTradeCount() + trades.size());
			group.setTotalCost(MathUtil.add(group.getTotalCost(), totalCost));
			myGroupService.update(group);
		} else {
			// 创建组合
			group = new MyGroup();
			group.setParentGroupId(parentGroupId);
			// 1自建，2跟买
			if(parentGroupId == null || parentGroupId != 0) {
				group.setGroupType(MyGroupTypeEnum.SELF.getCode());
			}else {
				group.setGroupType(MyGroupTypeEnum.VOTE.getCode());
			}
			group.setGroupName(userDynamicInfo.getTitle());
			group.setUserId(userId);
			group.setGroupDesc(userDynamicInfo.getMark());
			group.setFollowBuyNum(0L);
			group.setTotalTradeIncome(0D);
			group.setTodayTradeIncome(0D);
			group.setTradeCount(new Long(trades.size()));
			group.setTotalCost(totalCost);
			group.setProfitCount(0L);
			group.setLossCount(0L);
			group.setIsDel(MyGroupIsDelEnum.N.getCode());
			Date currDate = new Date();
			group.setCreateDate(currDate);
			group.setUpdateDate(currDate);
			myGroupService.save(group);

			// 组合数+1
			UserStatRecord userStatRecord = userStatRecordService.findById(userId);
			userStatRecord.setGroupNum(userStatRecord.getGroupNum() + 1);
			userStatRecordService.update(userStatRecord);
		}
		return group;
	}

	/**
	 * 根据条件查询条数
	 * @param userName
	 * @param type
	 * @return
	 */
	@Override
	public Long count(String userName,String type,String auditStatus,String createDateStart,String createDateEnd,String is_del, String isInput){
		return userDynamicInfoDao.count(userName, type, auditStatus, createDateStart, createDateEnd,is_del, isInput);
	}
	/**
	 * 根据条件查询
	 * @param userName
	 * @param type
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Map<String, Object>> find(String userName,String type,String auditStatus,String createDateStart,String createDateEnd,String is_del, String isInput, Long offset, Long rows){
		return userDynamicInfoDao.find(userName, type, auditStatus, createDateStart, createDateEnd,is_del, isInput, offset, rows);
	}

	/**
	 * 根据条件查询条数
	 * @param userName
	 * @param groupName
	 * @param type
	 * @return
	 */
	@Override
	public Long orderCount(String userName,String groupName,String type,String auditStatus, String isInput){
		return userDynamicInfoDao.orderCount(userName, groupName, type,auditStatus, isInput);
	}
	/**
	 * 根据条件查询
	 * @param userName
	 * @param groupName
	 * @param type
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Map<String, Object>> find(String userName,String groupName,String type,String auditStatus, String isInput, Long offset, Long rows){
		return userDynamicInfoDao.find(userName, groupName, type,auditStatus, isInput, offset, rows);
	}
}
