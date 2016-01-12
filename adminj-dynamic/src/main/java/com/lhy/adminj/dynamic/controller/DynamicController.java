package com.lhy.adminj.dynamic.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lhy.adminj.basic.enumeration.UserDynamicInfoIsDelEnum;
import com.lhy.adminj.basic.model.UserDynamicInfo;
import com.lhy.adminj.basic.service.UserDynamicInfoService;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;

/**
 * 动态Controllers
 * @author SDD
 * @version $v: 1.0.0, $time:2015/9/30 13:14 Exp $
 */
@Controller
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    private UserDynamicInfoService dynamicInfoService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /** 前台网站的URL **/
    @Value("#{properties['app.http.path']}")
    private String sail_web_url;

    /**
     * 动态信息管理
     **/
    @RequestMapping("/index.html")
    public ModelAndView index(ModelAndView view) {
        logger.info("动态信息管理");
        view.addObject("sail_web_url", sail_web_url);
        view.setViewName("/dynamic/index");
        return view;
    }
    
    /**
     * 动态信息管理列表记录
     **/
    @RequestMapping("/list.json")
    @ResponseBody
    public Page<Map<String, Object>> list(String userName,String type,String auditStatus,String createDateStart,String createDateEnd,String is_del, HttpServletRequest request) {
        logger.info("动态信息管理列表记录: userName:{},type:{},auditStatus:{},createDateStart:{},createDateEnd:{}",userName,type,auditStatus,createDateStart,createDateEnd);

        Page<Map<String, Object>> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(dynamicInfoService.count(userName, type, auditStatus, createDateStart, createDateEnd,is_del, null));
        // 分页记录
        List<Map<String, Object>> list = dynamicInfoService.find(userName, type, auditStatus, createDateStart, createDateEnd,is_del, null, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
    /**
     * 动态信息删除
     * @param dynamic_id
     * @return
     */
    @RequestMapping("/remove.json")
    @ResponseBody
    public String remove(Long dynamic_id){
    	String status ="1";
    	try {
			UserDynamicInfo dynamicInfo =  dynamicInfoService.findById(dynamic_id);
			dynamicInfo.setIsDel(UserDynamicInfoIsDelEnum.Y.getCode());
			dynamicInfoService.update(dynamicInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("动态信息删除异常 dynamic_id="+dynamic_id,e);
		}
    	return status;
    }

}
