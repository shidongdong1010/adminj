package com.lhy.adminj.reso.controller;

import com.lhy.adminj.basic.enumeration.SysHolidaysIsValidEnum;
import com.lhy.adminj.basic.enumeration.SysSensitiveWordIsValidEnum;
import com.lhy.adminj.basic.model.AnnouncementInfo;
import com.lhy.adminj.basic.model.SysHolidays;
import com.lhy.adminj.basic.model.SysSensitiveWord;
import com.lhy.adminj.basic.resultcode.SysHolidaysResultCode;
import com.lhy.adminj.basic.resultcode.SysSensitiveWordResultCode;
import com.lhy.adminj.basic.service.SysSensitiveWordService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
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
 * 敏感词库管理
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/19 10:22 Exp $
 */
@Controller
@RequestMapping("/reso/")
public class SensitiveWordController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysSensitiveWordService sysSensitiveWordService;

    @Autowired
    private JsonResultHelper jsonResultHelper;

    /**
     * 敏感词列表页
     * @return
     */
    @RequestMapping("/sensitiveWord/sensitiveWordList.html")
    public String sensitiveWordList(){
        return "/reso/sensitiveWord/sensitiveWordList";
    }

    /**
     * 敏感词列表页
     * @return
     */
    @ResponseBody
    @RequestMapping("/sensitiveWord/sensitiveWordList.json")
    public Page<SysSensitiveWord> sensitiveWordList(SysSensitiveWord sensitiveWord, HttpServletRequest request){
        logger.info("敏感词列表记录: {}", sensitiveWord);
        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(sensitiveWord);
        Page<SysSensitiveWord> page = PageUtil.getPage(request);

        // 统计总记录数
        page.setTotal(sysSensitiveWordService.count(sensitiveWord));
        // 查询列表
        List<SysSensitiveWord> list = sysSensitiveWordService.find(sensitiveWord, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    /**
     * 添加敏感词
     * @param sensitiveWord
     * @return
     */
    @ResponseBody
    @RequestMapping("/sensitiveWord/addSensitiveWord.json")
    public JsonResult addSensitiveWord(SysSensitiveWord sensitiveWord){
        SysSensitiveWord param = new SysSensitiveWord();
        param.setWord(sensitiveWord.getWord());
        param.setIsValid(SysSensitiveWordIsValidEnum.Y.getCode());
        List<SysSensitiveWord> list = sysSensitiveWordService.find(param);
        if(list != null && !list.isEmpty()){
            return jsonResultHelper.buildFailJsonResult(SysSensitiveWordResultCode.SENSITIVEWORD_EXISTS);
        }

        sensitiveWord.setCreateDate(new Date());
        sensitiveWord.setUpdateDate(new Date());
        sensitiveWord.setIsValid(SysSensitiveWordIsValidEnum.Y.getCode());
        sysSensitiveWordService.save(sensitiveWord);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 修改敏感词
     * @param sensitiveWord
     * @return
     */
    @ResponseBody
    @RequestMapping("/sensitiveWord/updateSensitiveWord.json")
    public JsonResult updateSensitiveWord(SysSensitiveWord sensitiveWord){
        SysSensitiveWord oldSysSensitiveWord = sysSensitiveWordService.findById(sensitiveWord.getWordId());
        //oldSysSensitiveWord.setWord(sensitiveWord.getWord());
        oldSysSensitiveWord.setMathType(sensitiveWord.getMathType());
        oldSysSensitiveWord.setIsValid(sensitiveWord.getIsValid());
        oldSysSensitiveWord.setUpdateDate(new Date());
        sysSensitiveWordService.update(oldSysSensitiveWord);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }
}
