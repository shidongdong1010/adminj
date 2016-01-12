package com.lhy.adminj.reso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lhy.adminj.basic.model.Province;
import com.lhy.adminj.basic.model.User;
import com.lhy.adminj.basic.model.UserBacklist;
import com.lhy.adminj.basic.model.UserDetail;
import com.lhy.adminj.basic.model.UserStatRecord;
import com.lhy.adminj.basic.service.UserService;
import com.lhy.adminj.basic.util.IPAddrUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.adminj.basic.util.password.PasswordUtil;

/**
 * 用户Controllers
 * @author wn
 * @version $v: 1.0.0, $time:2015/9/30 13:14 Exp $
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用户信息管理
     **/
    @RequestMapping("/index.html")
    public String index() {
        logger.info("用户信息管理");

        return "/user/index";
    }
    
    /**
     * 用户信息管理列表记录
     **/
    @RequestMapping("/list.json")
    @ResponseBody
    public Page<User> list(User user, HttpServletRequest request) {
    	
        Page<User> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(userService.count(user));
        // 分页记录
        List<User> list = userService.findLikeName(user, null,page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
    /**
     * 重置用户密码
     * @param userId
     * @param password
     * @return
     */
    @RequestMapping("/restPwd.json")
    @ResponseBody
    public String restPwd(Long userId,String password){
    	String status ="1";
    	try {
    		User user = userService.findById(userId);
    		user.setPassword(PasswordUtil.encode(password));
    		userService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("重置用户密码异常 userId="+userId+"&password="+password,e);
		}
    	return status;
    }
    /**
     * 添加用户
     * @param user
     * @param headImgPath 头像路径
	 * @param nickName 昵称
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/add.json")
    @ResponseBody
    public int save(User user,UserDetail userDetail,UserStatRecord userStatRecord,UserBacklist userBacklist, MultipartFile headImgFile, HttpServletRequest request, HttpServletResponse response){
    	int status = 1;
    	try {
    		user.setRegIp(IPAddrUtil.getIpAddr(request));
    		if(null!=user.getUserId()){
    			userService.saveUser(user, userDetail, userStatRecord, userBacklist, headImgFile.isEmpty()?null:headImgFile.getInputStream());
    		}else{
    			userService.addUser(user, userDetail, userStatRecord, userBacklist, headImgFile.getInputStream());
    		}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加用户异常 username="+user.getUserName(),e);
			status =2;
		}
    	return status;
    }
    @RequestMapping("/edit.json")
    @ResponseBody
    public Map<String, Object> edit(Long userId){
    	return userService.editUser(userId);
    }
}
