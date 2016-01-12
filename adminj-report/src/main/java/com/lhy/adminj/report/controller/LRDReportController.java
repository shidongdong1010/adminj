package com.lhy.adminj.report.controller;

import com.lhy.adminj.basic.model.UserBehaviorLog;
import com.lhy.adminj.basic.model.UserLoginInfo;
import com.lhy.adminj.basic.service.UserBehaviorLogService;
import com.lhy.adminj.basic.service.UserLoginInfoService;
import com.lhy.adminj.basic.service.UserService;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.common.lang.DateUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 登录、注册、下载的报表统计
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/30 11:19 Exp $
 */
@Controller
public class LRDReportController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginInfoService userLoginInfoService;
    @Autowired
    private UserBehaviorLogService userBehaviorLogService;
    @Autowired
    private JsonResultHelper jsonResultHelper;

    public static String firstDate =  "2015-10-01";

    @RequestMapping("/report/lrdTotalDataReport.html")
    public String lrdTotalDataReport(Model model){
        return "/report/lrdIndex";
    }

    /**
     * 总报表
     * @return
     */
    @RequestMapping("/report/lrdTotalDataReport.json")
    @ResponseBody
    public JsonResult lrdTotalDataReport(){
        // 总的注册数量
        Long reistTotalNum = userService.count(null);
        // 总的登陆数量
        Long loginTotalNum = userLoginInfoService.count(null);
        // 第一次打开APP数量
        Long firstOpenAppNum = userBehaviorLogService.countFirstOpenApp();

        Map<String, Object> data = new HashMap<>();
        data.put("categories", new String[]{"注册", "登陆", "第一次打开APP"});
        data.put("data", new Long[]{reistTotalNum, loginTotalNum, firstOpenAppNum});
        return jsonResultHelper.buildSuccessJsonResult(data);
    }

    /**
     * 按月报表
     * @return
     */
    @RequestMapping("/report/lrdMonthDataReport.json")
    @ResponseBody
    public JsonResult lrdMonthDataReport(){
        // 总的注册数量
        List<Map<String, Object>> registMonthNum = userService.registMonthCount(null);
        // 总的登陆数量
        List<Map<String, Object>> loginMonthNum = userLoginInfoService.loginMonthCount(null);
        // 第一次打开APP数量
        List<Map<String, Object>> firstOpenAppMonthNum = userBehaviorLogService.firstOpenAppMonthCount(null);

        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(DateUtil.parseDate(firstDate));
        Date currDate = new Date();

        List<String> months = new ArrayList<>();
        List<Long> registNums = new ArrayList<>();
        List<Long> loginNums = new ArrayList<>();
        List<Long> firstOpenAppNums = new ArrayList<>();
        while (calendar.getTime().before(currDate)){
            Date date = calendar.getTime();
            String year =  DateUtil.format(date, "yyyy");
            String month = DateUtil.format(date, "MM");
            months.add(DateUtil.format(date, "yyyy-MM"));
            registNums.add(getNum(registMonthNum, year, month));
            loginNums.add(getNum(loginMonthNum, year, month));
            firstOpenAppNums.add(getNum(firstOpenAppMonthNum, year, month));
            calendar.add(Calendar.MONTH, 1);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("categories", months);

        List<Map<String, Object>> series = new ArrayList<>();
        Map<String, Object> registSerie = new HashMap<>();
        registSerie.put("name", "注册");
        registSerie.put("data", registNums);
        series.add(registSerie);
        Map<String, Object> loginSerie = new HashMap<>();
        loginSerie.put("name", "登陆");
        loginSerie.put("data", loginNums);
        series.add(loginSerie);
        Map<String, Object> firstOpenAppSerie = new HashMap<>();
        firstOpenAppSerie.put("name", "第一次打开APP");
        firstOpenAppSerie.put("data", firstOpenAppNums);
        series.add(firstOpenAppSerie);
        data.put("series", series);
        return jsonResultHelper.buildSuccessJsonResult(data);
    }

    private Long getNum(List<Map<String, Object>> nums, String year, String month){
        for(Map<String, Object> map : nums){
            String cYear = map.get("year").toString();
            String cMonth = map.get("month").toString();
            if(year.equals(cYear) && month.equals(cMonth)){
                return Long.parseLong(map.get("num").toString());
            }
        }
        return 0L;
    }

    /**
     * 明细页
     * @return
     */
    @RequestMapping("/report/lrdTotalDataReportDetail.html")
    public String lrdTotalDataReportDetail(){
        return "/report/lrdDetailIndex";
    }

    /**
     * 总报表明细数据
     * @return
     */
    @RequestMapping("/report/lrdTotalDataReportDetail.json")
    @ResponseBody
    public Page<Map<String, Object>> lrdTotalDataReportDetail(HttpServletRequest request){
        Page<Map<String, Object>> page = PageUtil.getPage(request);

        // 总的注册数量
        Long reistTotalNum = userService.count(null);
        // 总的登陆数量
        Long loginTotalNum = userLoginInfoService.count(null);
        // 第一次打开APP数量
        Long firstOpenAppNum = userBehaviorLogService.countFirstOpenApp();

        // 分页记录
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> dataReg = new HashMap<>();
        dataReg.put("categorie", "注册");
        dataReg.put("data", reistTotalNum);
        list.add(dataReg);
        Map<String, Object> dataLogin = new HashMap<>();
        dataLogin.put("categorie", "登陆");
        dataLogin.put("data", loginTotalNum);
        list.add(dataLogin);
        Map<String, Object> firstOpenApp = new HashMap<>();
        firstOpenApp.put("categorie", "第一次打开APP");
        firstOpenApp.put("data", firstOpenAppNum);
        list.add(firstOpenApp);

        // 统计总记录数
        page.setTotal(list.size());
        page.setRows(list);
        return page;
    }

    /**
     * 按月表明细数据
     * @return
     */
    @RequestMapping("/report/lrdMonthDataReportDetail.json")
    @ResponseBody
    public Page<Map<String, Object>> lrdMonthDataReportDetail(HttpServletRequest request){
        Page<Map<String, Object>> page = PageUtil.getPage(request);

        // 总的注册数量
        List<Map<String, Object>> registMonthNum = userService.registMonthCount(null);
        // 总的登陆数量
        List<Map<String, Object>> loginMonthNum = userLoginInfoService.loginMonthCount(null);
        // 第一次打开APP数量
        List<Map<String, Object>> firstOpenAppMonthNum = userBehaviorLogService.firstOpenAppMonthCount(null);

        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(DateUtil.parseDate(firstDate));
        Date currDate = new Date();

        List<Map<String, Object>> list = new ArrayList<>();
        while (calendar.getTime().before(currDate)){
            Date date = calendar.getTime();
            String year =  DateUtil.format(date, "yyyy");
            String month = DateUtil.format(date, "MM");
            calendar.add(Calendar.MONTH, 1);

            Map<String, Object> data = new HashMap<>();
            data.put("year", year);
            data.put("month", month);
            data.put("registMonthNum", getNum(registMonthNum, year, month));
            data.put("loginMonthNum", getNum(loginMonthNum, year, month));
            data.put("firstOpenAppMonthNum", getNum(firstOpenAppMonthNum, year, month));
            list.add(data);
        }
        // 统计总记录数
        page.setTotal(list.size());
        page.setRows(list);
        return page;
    }
}
