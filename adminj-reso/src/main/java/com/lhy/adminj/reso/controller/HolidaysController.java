package com.lhy.adminj.reso.controller;

import com.lhy.adminj.basic.enumeration.SysHolidaysIsValidEnum;
import com.lhy.adminj.basic.enumeration.SysSensitiveWordIsValidEnum;
import com.lhy.adminj.basic.model.SysHolidays;
import com.lhy.adminj.basic.model.SysSensitiveWord;
import com.lhy.adminj.basic.resultcode.SysHolidaysResultCode;
import com.lhy.adminj.basic.service.SysHolidaysService;
import com.lhy.adminj.basic.service.SysSensitiveWordService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.common.lang.DateUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 节假日管理
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/19 10:35 Exp $
 */
@Controller
@RequestMapping("/reso/")
public class HolidaysController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysHolidaysService sysHolidaysService;

    @Autowired
    private JsonResultHelper jsonResultHelper;

    /**
     * 节假日列表页
     * @return
     */
    @RequestMapping("/holidays/holidaysList.html")
    public String holidaysList(){
        return "/reso/holidays/holidaysList";
    }

    /**
     * 节假日列表页
     * @return
     */
    @RequestMapping("/holidays/holidaysList.json")
    @ResponseBody
    public Page<SysHolidays> holidaysList(SysHolidays holidays, HttpServletRequest request){
        logger.info("节假日列表记录: {}", holidays);
        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(holidays);
        Page<SysHolidays> page = PageUtil.getPage(request);

        // 统计总记录数
        page.setTotal(sysHolidaysService.count(holidays));
        // 查询列表
        List<SysHolidays> list = sysHolidaysService.find(holidays, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    /**
     * 添加节假日
     * @param holidays
     * @return
     */
    @RequestMapping("/holidays/addHolidays.json")
    @ResponseBody
    public JsonResult addSensitiveWord(SysHolidays holidays){
        SysHolidays param = new SysHolidays();
        param.setHolidays(holidays.getHolidays());
        param.setIsValid(SysHolidaysIsValidEnum.Y.getCode());
        List<SysHolidays> list = sysHolidaysService.find(param);
        if(list != null && !list.isEmpty()){
            return jsonResultHelper.buildFailJsonResult(SysHolidaysResultCode.HOLIDAYS_EXISTS);
        }

        String year = DateUtil.format(holidays.getHolidays(), "yyyy");
        holidays.setYear(new Long(year));
        holidays.setCreateDate(new Date());
        holidays.setUpdateDate(new Date());
        holidays.setIsValid(SysHolidaysIsValidEnum.Y.getCode());
        sysHolidaysService.save(holidays);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 修改节假日
     * @param holidays
     * @return
     */
    @RequestMapping("/holidays/updateHolidays.json")
    @ResponseBody
    public JsonResult updateHolidays(SysHolidays holidays){
        SysHolidays oldSysHolidays = sysHolidaysService.findById(holidays.getHolidaysId());
        oldSysHolidays.setUpdateDate(new Date());
        oldSysHolidays.setIsValid(holidays.getIsValid());
        sysHolidaysService.update(oldSysHolidays);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }
}
