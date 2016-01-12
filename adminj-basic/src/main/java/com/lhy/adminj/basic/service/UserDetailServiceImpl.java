package com.lhy.adminj.basic.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.enumeration.UserDetailAgeEnum;
import com.lhy.adminj.basic.enumeration.UserDetailCompanyDutiesEnum;
import com.lhy.adminj.basic.enumeration.UserDetailSexEnum;
import com.lhy.adminj.basic.model.User;
import com.lhy.adminj.basic.model.UserDetail;
import com.lhy.adminj.basic.service.base.impl.UserDetailBaseServiceImpl;

/**
 * 用户简介表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserDetailServiceImpl extends UserDetailBaseServiceImpl implements UserDetailService {

	@Value("#{properties['city.code']}")
    private String cityCode;
    @Value("#{properties['city.name']}")
    private String cityName;
    @Value("#{properties['province.code']}")
    private String provinceCode;
    @Value("#{properties['province.name']}")
    private String provinceName;
    
	/**
     * 得到用户简介信息的默认值
     */
    @Override
    public void getDefaultUserDetail(User user,UserDetail userDetail) {
        userDetail.setUserId(user.getUserId()); // 用户ID
        if(StringUtils.isBlank(userDetail.getAge())){
        	userDetail.setAge(UserDetailAgeEnum.C.getCode()); // 年龄，默认25-35
        }
        if(StringUtils.isBlank(userDetail.getSex())){
        	userDetail.setSex(UserDetailSexEnum.S.getCode()); // 性别，默认保密
        }
        if(StringUtils.isBlank(userDetail.getCompanyDuties())){
        	userDetail.setCompanyDuties(UserDetailCompanyDutiesEnum.CHAIRMAN.getCode()); // 职务, 默认董事长
        }

        // 默认的省份与城市
        if(StringUtils.isBlank(userDetail.getCityCode())){
        	userDetail.setCityCode(cityCode);
        }
        if(StringUtils.isBlank(userDetail.getCityName())){
        	userDetail.setCityName(cityName);
        }
        if(StringUtils.isBlank(userDetail.getProvinceCode())){
        	userDetail.setProvinceCode(provinceCode);
        }
        if(StringUtils.isBlank(userDetail.getProvinceName())){
        	userDetail.setProvinceName(provinceName);
        }

    	userDetail.setCreateDate(new Date()); // 创建时间
    	userDetail.setUpdateDate(new Date()); // 更新时间

    }
}
