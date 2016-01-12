package com.lhy.adminj.report.controller;

import com.lhy.adminj.basic.enumeration.UserBehaviorLogCodeEnum;
import com.lhy.adminj.basic.model.UserBehaviorLog;
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
 * 用户行为日志报表
 * @author SDD
 * @version $v: 1.0.0, $time:2015/11/2 17:16 Exp $
 */
@Controller
public class OperationReportController {
    @Autowired
    private UserBehaviorLogService userBehaviorLogService;
    @Autowired
    private JsonResultHelper jsonResultHelper;

    @RequestMapping("/report/operationReport.html")
    public String operationReport(Model model){
        return "/report/operationIndex";
    }

    @RequestMapping("/report/operationReport.json")
    @ResponseBody
    public JsonResult operationReport(){
        // 统计的数量
        List<Map<String, Object>> list = userBehaviorLogService.operationCount(null);

        // 生成月份
        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(DateUtil.parseDate(LRDReportController.firstDate));
        Date currDate = new Date();
        List<String> categories = new ArrayList<>();
        while (calendar.getTime().before(currDate)){
            Date date = calendar.getTime();
            categories.add(DateUtil.format(date, "yyyy-MM"));
            calendar.add(Calendar.MONTH, 1);
        }

        // 添加每种类型，每个月份的数据
        List<Map<String, Object>> series = new ArrayList<>();
        for(UserBehaviorLogCodeEnum codeEnum : UserBehaviorLogCodeEnum.values()) {
            Map<String, Object> serie = new HashMap<>();
            serie.put("name", codeEnum.getDesc());

            List<Long> nums = new ArrayList<>();
            for(String yearMonth : categories) {
                String year = yearMonth.split("-")[0];
                String month = yearMonth.split("-")[1];

                nums.add(getNum(list, year, month, codeEnum.getCode()));
            }
            serie.put("data", nums);
            series.add(serie);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("categories", categories);
        data.put("series", series);
        return jsonResultHelper.buildSuccessJsonResult(data);
    }

    private Long getNum(List<Map<String, Object>> nums, String year, String month, String code){
        for(Map<String, Object> map : nums){
            String cYear = map.get("year").toString();
            String cMonth = map.get("month").toString();
            String cCode = map.get("code").toString();
            if(year.equals(cYear) && month.equals(cMonth) && code.equals(cCode)){
                return Long.parseLong(map.get("num").toString());
            }
        }
        return 0L;
    }

    /**
     * 明细页
     * @return
     */
    @RequestMapping("/report/operationReportDetail.html")
    public String lrdTotalDataReportDetail(){
        return "/report/operationIndexDetail";
    }

    @RequestMapping("/report/operationReportDetail.json")
    @ResponseBody
    public Page<Map<String, Object>> operationReportDetail(HttpServletRequest request){
        Page<Map<String, Object>> page = PageUtil.getPage(request);

        // 第一次打开APP数量
        List<Map<String, Object>> datas = userBehaviorLogService.operationCount(null);

        // 生成月份
        Calendar calendar  = Calendar.getInstance();
        calendar.setTime(DateUtil.parseDate(LRDReportController.firstDate));
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
            data.put("loginNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.A.getCode()));
            data.put("votoNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.B.getCode()));
            data.put("orderNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.C.getCode()));
            data.put("talkNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.D.getCode()));
            data.put("commentNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.E.getCode()));
            data.put("forwardNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.F.getCode()));
            data.put("rewardNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.G.getCode()));
            data.put("openAppNum", getNum(datas, year, month, UserBehaviorLogCodeEnum.H.getCode()));
            list.add(data);
        }

        // 统计总记录数
        page.setTotal(list.size());
        page.setRows(list);
        return page;
    }
}

