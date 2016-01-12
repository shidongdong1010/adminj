package com.lhy.adminj.basic.service;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lhy.adminj.basic.common.ImgHandleService;
import com.lhy.adminj.basic.enumeration.CityValidFlagEnum;
import com.lhy.adminj.basic.enumeration.UserPushSwitchEnum;
import com.lhy.adminj.basic.enumeration.UserSailCoinObtainFlowObtainWayEnum;
import com.lhy.adminj.basic.enumeration.UserSourceEnum;
import com.lhy.adminj.basic.enumeration.UserStatusEnum;
import com.lhy.adminj.basic.enumeration.UserTypeEnum;
import com.lhy.adminj.basic.enumeration.YesOrNoEnum;
import com.lhy.adminj.basic.model.City;
import com.lhy.adminj.basic.model.Province;
import com.lhy.adminj.basic.model.User;
import com.lhy.adminj.basic.model.UserBacklist;
import com.lhy.adminj.basic.model.UserDetail;
import com.lhy.adminj.basic.model.UserSailCoinObtainFlow;
import com.lhy.adminj.basic.model.UserSailCoinRule;
import com.lhy.adminj.basic.model.UserStatRecord;
import com.lhy.adminj.basic.service.base.impl.UserBaseServiceImpl;
import com.lhy.adminj.basic.util.password.PasswordUtil;

/**
 * 用户表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
@Transactional
public class UserServiceImpl extends UserBaseServiceImpl implements UserService {

	 @Autowired
	 private UserDetailService			 userDetailService;
	 @Autowired
     private ImgHandleService 	         imgHandleService;
	 @Autowired
	 private UserStatRecordService 		 userStatRecordService;
	 @Autowired
	 private UserBacklistService 		 userBacklistService;
	 @Autowired
	 private UserSailCoinObtainFlowService userSailCoinObtainFlowService;
	 @Autowired
	 private UserSailCoinRuleService 	  userSailCoinRuleService;
	 @Autowired
	 private ProvinceService 	  		  provinceService;
	 @Autowired
	 private CityService 	 			  cityService;
	 
	 
	/**
	 * 根据对象查询支持用户名模糊查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<User> findLikeName(User user,String[][] orders, Long offset, Long rows){
		return userDao.findLikeName(user, orders,offset, rows);
	}
	/**
	 * 添加用户
	 * @param user
	 * @param headImgPath 头像路径
	 * @param nickName 昵称
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 1000, rollbackFor = Exception.class)
	public void addUser(User user,UserDetail userDetail,UserStatRecord userStatRecord,UserBacklist userBacklist,InputStream imgFileIs){
			// 保存用户信息
			getDefaultUser(user);
			userDao.save(user);
			queryProcinveCityName(userDetail);
            userDetailService.getDefaultUserDetail(user,userDetail);
            // 保存用户头像
            if(null!=imgFileIs){
            	String picName = imgHandleService.saveHeadImg(imgFileIs, user.getUserId());
            	userDetail.setHeadImgPath(picName);
            }
            userDetailService.save(userDetail);
            // 保存用户统计信息
            userStatRecordService.save(UserStatRecord.userStatRecordInit(user.getUserId(), userStatRecord));
            // 保存用户黑名单
            userBacklistService.save(UserBacklist.userBacklistInit(user.getUserId(), userBacklist));
            // 注册增送金币
            updateSailCoin(user);
	}
	/**
	 * 保存用户
	 * @param user
	 * @param userDetail
	 * @param userStatRecord
	 * @param userBacklist
	 * @param imgFileIs
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 1000, rollbackFor = Exception.class)
	public void saveUser(User user,UserDetail userDetail,UserStatRecord userStatRecord,UserBacklist userBacklist,InputStream imgFileIs){
		Long userId = user.getUserId();
		User oldUser = userDao.findById(userId);
		UserDetail oldUserDetail = userDetailService.find(new UserDetail(userId)).get(0);
		UserStatRecord oldUserStatRecord = userStatRecordService.find(new UserStatRecord(userId)).get(0);
		UserBacklist oldUserBacklist = userBacklistService.find(new UserBacklist(userId)).get(0);
		
		user.setCreateDate(oldUser.getCreateDate());
		user.setUpdateDate(new Date());
		//如果已修改密码，则重新加密保存
		if(!user.getPassword().equals(oldUser.getPassword())){
			user.setPassword(PasswordUtil.encode(user.getPassword()));
		}
		userDao.update(user);
		// 保存用户头像
        if(null!=imgFileIs){
        	String picName = imgHandleService.saveHeadImg(imgFileIs, user.getUserId());
        	userDetail.setHeadImgPath(picName);
        }else{
        	userDetail.setHeadImgPath(oldUserDetail.getHeadImgPath());
        }
        queryProcinveCityName(userDetail);
        userDetail.setCreateDate(oldUserDetail.getCreateDate());
        userDetail.setUpdateDate(new Date());
		userDetailService.update(userDetail);
		userStatRecord.setCreateDate(oldUserStatRecord.getCreateDate());
		userStatRecord.setUpdateDate(new Date());
		userStatRecordService.update(userStatRecord);
		userBacklist.setCreateDate(oldUserBacklist.getCreateDate());
		userBacklist.setUpdateDate(new Date());
		userBacklistService.update(userBacklist);
	}
	/**
	 * 填充省份城市名称
	 * @param userDetail
	 */
	private void queryProcinveCityName(UserDetail userDetail) {
		if(StringUtils.isNotBlank(userDetail.getProvinceCode())){
			List<Province> provinces = provinceService.find(new Province(Long.parseLong(userDetail.getProvinceCode())));
			if(provinces.size()>0){
				userDetail.setProvinceName(provinces.get(0).getProvCnName());
			}
		}
		if(StringUtils.isNotBlank(userDetail.getCityCode())){
			List<City> cities = cityService.find(new City(Long.parseLong(userDetail.getProvinceCode()), CityValidFlagEnum.Y.getCode()));
			if(cities.size()>0){
				userDetail.setCityName(cities.get(0).getCityName());
			}
		}
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 1000, rollbackFor = Exception.class)
	public Map<String, Object> editUser(Long userId){
		User user = userDao.findById(userId);
		UserDetail userDetail = userDetailService.find(new UserDetail(userId)).get(0);
		UserStatRecord userStatRecord = userStatRecordService.find(new UserStatRecord(userId)).get(0);
		UserBacklist userBacklist = userBacklistService.find(new UserBacklist(userId)).get(0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("userDetail", userDetail);
		map.put("userStatRecord", userStatRecord);
		map.put("userBacklist", userBacklist);
		return map;
	}
	/**
	 * 注册增送金币
	 * @param user
	 */
	private void updateSailCoin(User user){
		UserSailCoinRule userSailCoinRule = new UserSailCoinRule();
		userSailCoinRule.setRuleType(UserSailCoinObtainFlowObtainWayEnum.A1.getCode());
		List<UserSailCoinRule> coinRules = userSailCoinRuleService.findEffective(userSailCoinRule, null, null, null);
		UserSailCoinRule coinRule = coinRules.get(0);
		UserSailCoinObtainFlow userSailCoinObtainFlow = new UserSailCoinObtainFlow();
		userSailCoinObtainFlow.setAwardNum(coinRule.getCoinNum());
		userSailCoinObtainFlow.setObtainWay(UserSailCoinObtainFlowObtainWayEnum.A1.getCode());
		Date currDate = new Date();
		userSailCoinObtainFlow.setUserId(user.getUserId());
		userSailCoinObtainFlow.setCreateDate(currDate);
		userSailCoinObtainFlow.setIsDel(YesOrNoEnum.N.getCode());
		userSailCoinObtainFlow.setUpdateDate(currDate);
		userSailCoinObtainFlowService.save(userSailCoinObtainFlow);
		user.setSailCurrency(user.getSailCurrency() + userSailCoinObtainFlow.getAwardNum());
		userDao.update(user);
	}
	// 得到用户的默认值
    private void getDefaultUser(User user) {
    	if(StringUtils.isBlank(user.getType())){
    		user.setType(UserTypeEnum.LHY.getCode()); // 会员类型， 默认内部)
    	}
    	if(StringUtils.isBlank(user.getStatus())){
    		user.setStatus(UserStatusEnum.A0.getCode()); // 账号状态，默认正常)
    	}
    	if(StringUtils.isBlank(user.getPushSwitch())){
    		user.setPushSwitch(UserPushSwitchEnum.A1.getCode()); // 推送设置，默认开
    	}
    	if(null==user.getSailCurrency()){
    		user.setSailCurrency(0d); // 航币数
    	}
    	user.setCreateDate(new Date()); // 创建时间
        user.setUpdateDate(new Date()); // 更新时间
        if(StringUtils.isBlank(user.getUserSource())){
        	user.setUserSource(UserSourceEnum.SAIL.getCode());
    	}
        // 密码加密
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        if(StringUtils.isBlank(user.getClientId())){
        	user.setClientId("");;
    	}
    }


	/**
	 * 注册数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> registMonthCount(Integer year){
		return userDao.registMonthCount(year);
	}
}
