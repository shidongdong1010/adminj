package com.lhy.adminj.basic.service;

import com.lhy.adminj.basic.model.User;
import com.lhy.adminj.basic.model.UserDetail;
import com.lhy.adminj.basic.service.base.UserDetailBaseService;

/**
 * 用户简介表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDetailService extends UserDetailBaseService {

	/**
     * 得到用户简介信息的默认值
     */
	void getDefaultUserDetail(User user,UserDetail userDetail);

}
