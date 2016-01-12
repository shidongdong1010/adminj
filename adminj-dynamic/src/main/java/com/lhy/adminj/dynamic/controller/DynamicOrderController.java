package com.lhy.adminj.dynamic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhy.adminj.basic.model.*;
import com.lhy.adminj.basic.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lhy.adminj.basic.common.ImgHandleService;
import com.lhy.adminj.basic.enumeration.TradeIsRevokeEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicCommentIsDelEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicCommentShowLocationEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicInfoAuditStatusEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicInfoIsInputEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicInfoTypeEnum;
import com.lhy.adminj.basic.enumeration.UserTypeEnum;
import com.lhy.adminj.basic.util.MathUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.adminj.basic.util.security.AuthUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;

/**
 * 动态的晒单Controller
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/9 16:28 Exp $
 */
@Controller
@RequestMapping("/dynamic")
public class DynamicOrderController {

    @Autowired
    private UserDynamicInfoService userDynamicInfoService;
    
    @Autowired
    private UserDynamicCommentService dynamicCommentService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserStockPositionService userStockPositionService;

    @Autowired
    private StockService stockService;

    @Autowired
    private MyGroupService myGroupService;

    @Autowired
    private MyGroupDetailService myGroupDetailService;

    @Autowired
    private JsonResultHelper       jsonResultHelper;
    
    @Autowired
    private UUserService uUserService;
    
    @Autowired
    private ImgHandleService 	         imgHandleService;

    /** 前台网站的URL **/
    @Value("#{properties['app.http.path']}")
    private String sail_web_url;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 晒单列表页面
     **/
    @RequestMapping("/orderInputList.html")
    public String orderInputList() {
        logger.info("晒单录入列表界面");

        return "/dynamic/order/orderInputList";
    }

    /**
     * 晒单列表记录
     **/
    @RequestMapping("/orderInputList.json")
    @ResponseBody
    public Page<Map<String, Object>> orderInputList(String userName, String groupName, HttpServletRequest request) {
        logger.info("晒单录入列表记录: {}, {}", userName, groupName);

        Page<Map<String, Object>> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(userDynamicInfoService.count(userName, UserDynamicInfoTypeEnum.S.getCode(), null, null, null, null, UserDynamicInfoIsInputEnum.N.getCode()));
        // 分页记录
        List<Map<String, Object>> list = userDynamicInfoService.find(userName, UserDynamicInfoTypeEnum.S.getCode(), null, null, null, null, UserDynamicInfoIsInputEnum.N.getCode(), page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    /**
     * 晒单录入页面
     **/
    @RequestMapping("/orderInput.html")
    public String orderInput(Long dynamicId, Model model) {
        logger.info("晒单录入界面: {}", dynamicId);
        // 查询晒单的动态记录
        UserDynamicInfo userDynamicInfo = userDynamicInfoService.findById(dynamicId);
        // 查询用户信息
        User user = userService.findById(userDynamicInfo.getUserId());
        // 查询用户的持仓
        UserStockPosition userStockPositionParam = new UserStockPosition();
        userStockPositionParam.setUserId(user.getUserId());
        List<UserStockPosition> stockPositions = userStockPositionService.find(userStockPositionParam);

        String[] paths = userDynamicInfo.getImagePath().split(";");
        model.addAttribute("paths", paths);
        model.addAttribute("sail_web_url", sail_web_url);
        model.addAttribute("userDynamicInfo", userDynamicInfo);
        model.addAttribute("user", user);
        model.addAttribute("stockPositions", stockPositions);

        if(UserTypeEnum.getByCode(user.getType()).equals(UserTypeEnum.CATTLE)) {
            return "/dynamic/order/orderInput";
        }else{
            // 查询跟投的组合
            MyGroup voteGroup = myGroupService.findById(userDynamicInfo.getGroupId());
            // 查询组合的用户
            User voteGroupUser = userService.findById(voteGroup.getUserId());
            // 查询跟投的组合的股票明细
            List<Map<String, Object>> voteGroupDetails = myGroupDetailService.findAndCurrPrice(voteGroup.getGroupId());

            model.addAttribute("voteGroup", voteGroup);
            model.addAttribute("voteGroupUser", voteGroupUser);
            model.addAttribute("voteGroupDetails", voteGroupDetails);
            return "/dynamic/order/orderInputVote";
        }
    }

    /**
     * 晒单录入操作
     **/
    @RequestMapping("/orderInput.json")
    @ResponseBody
    public JsonResult orderInput(Long dynamicId, Long userId, @RequestParam(value = "stockCode") String[] stockCodes,
                             @RequestParam(value = "num") Long[] nums, @RequestParam(value = "tradeType") String[] tradeTypes,
                             @RequestParam(value = "tradePrice") Double[] tradePrices, String auditDesc, Long parentGroupId, HttpServletRequest request) {
        // 查询晒单的动态记录
        UserDynamicInfo userDynamicInfo = userDynamicInfoService.findById(dynamicId);
        userDynamicInfo.setAuditDesc(auditDesc);

        List<Trade> trades = new ArrayList<Trade>();
        for (int i = 0; i < stockCodes.length; i++) {
            String stockCode = stockCodes[i];
            Trade trade = new Trade();
            trade.setUserId(userId);

            Stock stock = stockService.findByStockCode(stockCode);
            trade.setStockId(stock.getStockId());
            trade.setStockCode(stockCode);
            trade.setStockName(stock.getStockName());
            if(tradePrices != null && tradePrices.length > i) {
                trade.setTradePrice(tradePrices[i]);
            }
            if(nums != null && nums.length > i) {
                trade.setTradeNumber(nums[i]);
            }
            trade.setTurnoverAmount(MathUtil.mul((trade.getTradePrice() == null ? 0 : trade.getTradePrice()), trade.getTradeNumber()));
            trade.setTradeType(tradeTypes[i]);
            trade.setIsRevoke(TradeIsRevokeEnum.N.getCode());
            trade.setTradeDate(userDynamicInfo.getCreateDate());
            trade.setTradeTime(userDynamicInfo.getCreateDate());
            Date currDate = new java.util.Date();
            trade.setCreateDate(currDate);
            trade.setUpdateDate(currDate);
            trade.setTradeDate(currDate);
            trade.setTradeTime(currDate);
            trade.setShareholderCode(stock.getStockCode());
            trades.add(trade);
        }
        // 添加晒单
        userDynamicInfoService.addOrder(userDynamicInfo, trades, userId, parentGroupId);

        //return jsonResultHelper.buildFailJsonResult(UserDynamicInfoResultCode.SIGN_ERROR);
        return jsonResultHelper.buildSuccessJsonResult(true);
    }

    /**
     * 晒单作废操作
     **/
    @RequestMapping("/orderInputCancel.json")
    @ResponseBody
    public JsonResult orderInputCancel(Long dynamicId, String auditDesc){
        // 查询晒单的动态记录
        UserDynamicInfo userDynamicInfo = userDynamicInfoService.findById(dynamicId);
        userDynamicInfo.setAuditDesc(auditDesc);

        // 将此条记录修改成审批通过
        userDynamicInfo.setAuditDate(new java.util.Date());
        userDynamicInfo.setAuditName(AuthUtil.getUserName());
        userDynamicInfo.setAuditStatus(UserDynamicInfoAuditStatusEnum.D.getCode());
        userDynamicInfo.setIsInput(UserDynamicInfoIsInputEnum.Y.getCode());
        userDynamicInfoService.update(userDynamicInfo);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 晒单信息管理
     **/
    @RequestMapping("/orderIndex.html")
    public ModelAndView orderIndex(ModelAndView view) {
        logger.info("晒单信息管理");
        view.addObject("sail_web_url", sail_web_url);
        view.setViewName("/dynamic/order/orderIndex");
        return view;
    }
    /**
     * 晒单信息管理列表记录
     **/
    @RequestMapping("/orderList.json")
    @ResponseBody
    public Page<Map<String, Object>> orderList(String userName,String groupName,String auditStatus, HttpServletRequest request) {
        logger.info("晒单信息管理列表记录: userName,groupName", userName,groupName);

        Page<Map<String, Object>> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(userDynamicInfoService.orderCount(userName, groupName, UserDynamicInfoTypeEnum.S.getCode(),auditStatus, null));
        // 分页记录
        List<Map<String, Object>> list = userDynamicInfoService.find(userName, groupName, UserDynamicInfoTypeEnum.S.getCode(),auditStatus, null, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
    /**
     * 晒单信息屏蔽
     * @param dynamic_id
     * @return
     */
    @RequestMapping("/orderCancel.json")
    @ResponseBody
    public String orderCancel(Long dynamic_id,String auditDesc) {
        logger.info("晒单信息屏蔽: dynamic_id", dynamic_id);
        String status = "1";
        try {
			UserDynamicInfo userDynamicInfo =  userDynamicInfoService.findById(dynamic_id);
			userDynamicInfo.setAuditStatus(UserDynamicInfoAuditStatusEnum.D.getCode());
			userDynamicInfo.setAuditDesc(auditDesc);
			userDynamicInfo.setAuditDate(new Date());
			Long userId = AuthUtil.getUserId();
			UUser user = uUserService.findById(userId);
			userDynamicInfo.setAuditName(user.getFullname());
			userDynamicInfoService.update(userDynamicInfo);
		} catch (Exception e) {
			e.printStackTrace();
			status = "2";
			logger.error("晒单信息屏蔽异常: dynamic_id="+dynamic_id,e);
		}
        
        return status;
    }
    /**
     * 晒单回复
     * @param request
     * @param response
     * @param commentFile
     * @param content
     * @param dynamic_id
     * @return
     */
    @RequestMapping(value = "/orderComment.html", method = RequestMethod.POST)
    public ModelAndView orderComment(ModelAndView view,HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam MultipartFile commentFile, String content, Long dynamic_id,Long user_id,String fowordPath){
    	
    	try {
			User user = new User();
			user.setType(UserTypeEnum.LHY.getCode());
			List<User> users = userService.find(user);
			Long commentUserId = 0L;
			if(users.size()>0){
				Random r = new Random();
				int n = r.nextInt(users.size()-1);
				commentUserId = users.get(n).getUserId();
			}

			UserDynamicComment comment = new UserDynamicComment();
			//保存回复图片
			if(!commentFile.isEmpty()){
				String picName = imgHandleService.saveHeadImg(commentFile.getInputStream(), commentUserId);
				comment.setImagePath(picName);
			}
			comment.setDynamicId(dynamic_id);
			comment.setComment(content);
			comment.setCommentUserId(commentUserId);
			comment.setCreateDate(new Date());
			comment.setUserId(user_id);
			comment.setPraiseNum(0l);
			comment.setUpdateDate(new Date());
			comment.setIsDel(UserDynamicCommentIsDelEnum.N.getCode());
			comment.setShowLocation(UserDynamicCommentShowLocationEnum.N.getCode());
			comment.setGiveUserId(0l);//默认值
			dynamicCommentService.save(comment);
			 
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("晒单回复异常: dynamic_id="+dynamic_id, e);
		}
        view.addObject("sail_web_url", sail_web_url);
        view.setViewName(fowordPath);
    	return view;
    }
}
