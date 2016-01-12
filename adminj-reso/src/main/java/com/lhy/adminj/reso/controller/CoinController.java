package com.lhy.adminj.reso.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.adminj.basic.model.AdvertisingInfo;
import com.lhy.adminj.basic.model.UserSailCoinRule;
import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;
import com.lhy.adminj.basic.service.UserSailCoinRuleLoginService;
import com.lhy.adminj.basic.service.UserSailCoinRuleService;
import com.lhy.common.lang.StringUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;

@Controller
@RequestMapping("/coin")
public class CoinController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserSailCoinRuleService userSailCoinRuleService;
	
	@Autowired
	private UserSailCoinRuleLoginService userSailCoinRuleLoginService;
	
	@Autowired
    private JsonResultHelper       jsonResultHelper;
	
	private static String  USER_ACCOUNT_NUM = "1";//用户账户相关送航币规则
	
	private static String  USER_LIVE_NUM = "2";//用户活跃赠送航币规则
	
	private static String  USER_LOGIN_NUM = "3";//用户登录赠送航币规则
	
	private static String  REGIST = "1";//注册
	private static String  RECOFRIEN = "2";//推荐好友下载
	private static String  PERFECTINFO = "3";//完善信息
	private static String  UPLOADPHOTOS = "8";//上传头像
	private static String  VERIFIED = "9";//实名认证
	private static String  BINDBANKCARD = "10";//绑定银行卡
	private static String  POSTEDTALK = "6";//发表说说
	private static String  ASK = "11";//提问
	private static String  SHOWORDER = "7";//晒单
	private static String  OPERATING = "5";//操作
	
	private static String  LOGIN = "4";//连续登陆
	
	private static String  INDEX_1 = "1,2,3,8,9,10";
	
	private static String  INDEX_2 = "6,11,7,5";
	
	public static Map<String, String> getFeGoldPrizetTypeMap() {
		Map<String, String> its = new HashMap<String, String>();
		its.put(REGIST, "注册");
		its.put(RECOFRIEN, "推荐好友下载");
		its.put(PERFECTINFO, "完善信息");
		its.put(UPLOADPHOTOS, "上传头像 ");
		its.put(VERIFIED, "实名认证");
		its.put(BINDBANKCARD, "绑定银行卡");
		its.put(POSTEDTALK, "发表说说");
		its.put(ASK, "提问");
		its.put(SHOWORDER, "晒单");
		its.put(OPERATING, "操作");
		its.put(LOGIN, "连续登陆");
		return its;
	}
	
	public static Map<String, String> getFeGoldPrizetKeyMap() {
		Map<String, String> its = new HashMap<String, String>();
		its.put(REGIST, "regist");
		its.put(RECOFRIEN, "recofrien");
		its.put(PERFECTINFO, "perfectinfo");
		its.put(UPLOADPHOTOS, "uploadphotos");
		its.put(VERIFIED, "verified");
		its.put(BINDBANKCARD, "bindbankcard");
		its.put(POSTEDTALK, "postedtalk");
		its.put(ASK, "ask");
		its.put(SHOWORDER, "showorder");
		its.put(OPERATING, "operating");
		its.put(LOGIN, "login");
		return its;
	}
	
	
	
	/**
     * 奖励航币页面
     **/
    @RequestMapping("/coinInfo.html")
    public String coinInfo(HttpServletRequest request,Model model) {
        logger.info("奖励航币界面");
        //查询航币奖励规则表(除登录)
        List<UserSailCoinRule> userSailCoinRuleList = userSailCoinRuleService.findAll();
        if(null!=userSailCoinRuleList && userSailCoinRuleList.size()>0){
        	for(UserSailCoinRule userSailCoinRule : userSailCoinRuleList){
        		model.addAttribute(getFeGoldPrizetKeyMap().get(userSailCoinRule.getRuleType()), userSailCoinRule);
        	}
        }
        //查询航币奖励规则表(登录)
        List<UserSailCoinRuleLogin> userSailCoinRuleLoginList = userSailCoinRuleLoginService.findAll();
        if(null!=userSailCoinRuleLoginList && userSailCoinRuleLoginList.size()>0){
        	model.addAttribute("flag", 1);
        }else{
        	model.addAttribute("flag", 0);
        }
        model.addAttribute("userSailCoinRuleLoginList", userSailCoinRuleLoginList);
        return "/coin/coinOper";
    }
    
    /**
     * 编辑航币信息
     * @param request
     * @return
     */
    @RequestMapping("/editCoin.json")
    @ResponseBody
    public JsonResult editCoin(HttpServletRequest request) {
    	try{
    		String index =  request.getParameter("index");
    		if(USER_ACCOUNT_NUM.equals(index)){
    			String registNum = request.getParameter("registNum");//注册
    			String recoFrienNum = request.getParameter("recoFrienNum");//推荐好友下载
    			String perfectInfoNum = request.getParameter("perfectInfoNum");//完善账户信息
    			String uploadPhotosNum = request.getParameter("uploadPhotosNum");//上传头像
    			String verifiedNum = request.getParameter("verifiedNum");//实名认证
    			String bindBankCardNum = request.getParameter("registNum");//绑定银行卡
    			//更新前面的规则为失效
    			userSailCoinRuleService.updateCoin(INDEX_1);
    			//注册
    			UserSailCoinRule regist = getUserSailCoinRule(new Double(registNum),REGIST);
    			userSailCoinRuleService.save(regist);
    			//推荐好友下载
    			UserSailCoinRule recoFrien = getUserSailCoinRule(new Double(recoFrienNum),RECOFRIEN);
    			userSailCoinRuleService.save(recoFrien);
    			//完善账户信息
    			UserSailCoinRule perfectInfo = getUserSailCoinRule(new Double(perfectInfoNum),PERFECTINFO);
    			userSailCoinRuleService.save(perfectInfo);
    			//上传头像
    			UserSailCoinRule uploadPhotos = getUserSailCoinRule(new Double(uploadPhotosNum),UPLOADPHOTOS);
    			userSailCoinRuleService.save(uploadPhotos);
    			//实名认证
    			UserSailCoinRule verified = getUserSailCoinRule(new Double(verifiedNum),VERIFIED);
    			userSailCoinRuleService.save(verified);
    			//绑定银行卡
    			UserSailCoinRule bindBankCard = getUserSailCoinRule(new Double(bindBankCardNum),BINDBANKCARD);
    			userSailCoinRuleService.save(bindBankCard);
    		}else if(USER_LIVE_NUM.equals(index)){
    			String postedTalkNum = request.getParameter("postedTalkNum");//说说
    			String askNum = request.getParameter("askNum");//提问
    			String showOrderNum = request.getParameter("showOrderNum");//晒单
    			String operatingNum = request.getParameter("operatingNum");//操作
    			//更新前面的规则为失效
    			userSailCoinRuleService.updateCoin(INDEX_2);
    			//说说
    			UserSailCoinRule postedTalk = getUserSailCoinRule(new Double(postedTalkNum),POSTEDTALK);
    			userSailCoinRuleService.save(postedTalk);
    			//提问
    			UserSailCoinRule ask = getUserSailCoinRule(new Double(askNum),ASK);
    			userSailCoinRuleService.save(ask);
    			//晒单
    			UserSailCoinRule showOrder = getUserSailCoinRule(new Double(showOrderNum),SHOWORDER);
    			userSailCoinRuleService.save(showOrder);
    			//操作
    			UserSailCoinRule operating = getUserSailCoinRule(new Double(operatingNum),OPERATING);
    			userSailCoinRuleService.save(operating);
    		}else if(USER_LOGIN_NUM.equals(index)){
    			
    			String [] fromDay = request.getParameterValues("fromDay");
    			String [] toDay = request.getParameterValues("toDay");
    			String [] coinNums = request.getParameterValues("coinNum");
    			//更新前面的规则为失效
				userSailCoinRuleLoginService.updateCoin();
    			for(int i=0;i<fromDay.length;i++){
    				UserSailCoinRuleLogin userSailCoinRuleLogin = null;
    				if(fromDay.length==toDay.length){
    					userSailCoinRuleLogin = getUserSailCoinRuleLogin(new Double(coinNums[i]),LOGIN,fromDay[i],toDay[i]);
    				}else{
    					if(i==fromDay.length-1){
    						userSailCoinRuleLogin = getUserSailCoinRuleLogin(new Double(coinNums[i]),LOGIN,fromDay[i],"");
    					}else{
    						userSailCoinRuleLogin = getUserSailCoinRuleLogin(new Double(coinNums[i]),LOGIN,fromDay[i],toDay[i]);
    					}
    				}
    				//新增记录
    				userSailCoinRuleLoginService.save(userSailCoinRuleLogin);
    			}
    		}
    	}catch(Exception e){
         	e.printStackTrace();
         	logger.info(e.getMessage());
         	return jsonResultHelper.buildFailJsonResultWithErrorMsg("编辑航币信息失败！");
        }
    	return jsonResultHelper.buildSuccessJsonResult("编辑航币信息成功");
    }
    
    private UserSailCoinRule getUserSailCoinRule(Double num,String type){
    	UserSailCoinRule userSailCoinRule = new UserSailCoinRule();
    	userSailCoinRule.setCoinNum(new Double(num));
    	userSailCoinRule.setEffeTime(new Date());
    	userSailCoinRule.setRuleName(getFeGoldPrizetTypeMap().get(type));
    	userSailCoinRule.setRuleType(type);
		return userSailCoinRule;
    }
	
    private UserSailCoinRuleLogin getUserSailCoinRuleLogin(Double num,String type,String minDay,String maxDay){
    	UserSailCoinRuleLogin userSailCoinRuleLogin = new UserSailCoinRuleLogin();
    	userSailCoinRuleLogin.setCoinNum(new Double(num));
    	userSailCoinRuleLogin.setMinDay(Long.parseLong(minDay));
    	if(!StringUtil.isBlank(maxDay)){
    		userSailCoinRuleLogin.setMaxDay(Long.parseLong(maxDay));
    	}
    	userSailCoinRuleLogin.setRuleType(type);
    	userSailCoinRuleLogin.setRuleName(getFeGoldPrizetTypeMap().get(type));
    	userSailCoinRuleLogin.setEffeTime(new Date());
    	return userSailCoinRuleLogin;
    	
    }
}
