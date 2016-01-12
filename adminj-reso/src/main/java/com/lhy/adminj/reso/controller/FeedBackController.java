package com.lhy.adminj.reso.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.adminj.basic.model.AdvertisingInfo;
import com.lhy.adminj.basic.model.UserFeedBackInfo;
import com.lhy.adminj.basic.service.UserFeedBackInfoService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;


@Controller
@RequestMapping("/feedBack")
public class FeedBackController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private JsonResultHelper       jsonResultHelper;
	
	@Autowired
	private UserFeedBackInfoService userFeedBackInfoService;
	
	/**
     * 意见反馈列表页面
     **/
    @RequestMapping("/feedBackList.html")
    public String feedBackList() {
        logger.info("意见反馈列表界面");
        return "/feedBack/feedBackList";
    }
    
    /**
     * 意见反馈列表记录
     **/
    @RequestMapping("/feedBackDataList.json")
    @ResponseBody
    public Page<UserFeedBackInfo> feedBackDataList(UserFeedBackInfo userFeedBackInfo, HttpServletRequest request) {
        logger.info("意见反馈列表记录: {}", userFeedBackInfo);

        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(userFeedBackInfo);

        // 设置条件，只查询未审核的晒单记录

        Page<UserFeedBackInfo> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(userFeedBackInfoService.count(userFeedBackInfo));
        List<UserFeedBackInfo> list = userFeedBackInfoService.findList(userFeedBackInfo, page.getFirst(), page.getPageSize());
        
        page.setRows(list);
        return page;
    }
}
