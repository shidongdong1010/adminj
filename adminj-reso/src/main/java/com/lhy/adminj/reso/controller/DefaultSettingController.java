package com.lhy.adminj.reso.controller;

import com.lhy.adminj.basic.enumeration.UMenuIsLeafEnum;
import com.lhy.adminj.basic.model.SysDefaultSetting;
import com.lhy.adminj.basic.model.UMenu;
import com.lhy.adminj.basic.service.SysDefaultSettingService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.adminj.basic.util.security.AuthUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 默认值设置
 * @author SDD
 * @version $v: 1.0.0, $time:2015/11/2 14:22 Exp $
 */
@Controller
@RequestMapping("/reso")
public class DefaultSettingController {

    @Autowired
    private SysDefaultSettingService sysDefaultSettingService;
    @Autowired
    private JsonResultHelper jsonResultHelper;

    @RequestMapping("/defaultSetting.html")
    public String defaultSetting(Model model){
        return "/reso/defaultSetting/defaultSetting";
    }

    @RequestMapping("/defaultSetting.json")
    @ResponseBody
    public Page<SysDefaultSetting> defaultSetting(HttpServletRequest request){
        List<SysDefaultSetting> defaultSettingList = sysDefaultSettingService.find(null);

        Page<SysDefaultSetting> page = PageUtil.getPage(request);
        String sql ="";
        // 统计总记录数
        page.setTotal(sysDefaultSettingService.count(null));
        // 分页记录
        List<SysDefaultSetting> list = sysDefaultSettingService.find(null, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    @RequestMapping("/saveDefaultSetting.json")
    @ResponseBody
    public JsonResult saveDefaultSetting(@RequestBody List<Map<String, Object>> menus){
        for(Map<String, Object> m : menus) {
            String action = m.get("action").toString();
            SysDefaultSetting defaultSetting = new SysDefaultSetting();
            defaultSetting.setCode(m.get("code") == null ? null : m.get("code").toString());
            defaultSetting.setValue(m.get("value") == null ? null : m.get("value").toString());
            defaultSetting.setDesc(m.get("desc") == null ? null : m.get("desc").toString());

            if (action.equals("update")) {
                sysDefaultSettingService.update(defaultSetting);
            } else if (action.equals("insert")) {
                defaultSetting.setCreateTime(new Date());
                defaultSetting.setCreateUserId(AuthUtil.getUserId());
                sysDefaultSettingService.save(defaultSetting);
            } else if (action.equals("delete")) {
                sysDefaultSettingService.delete(defaultSetting.getCode());
            }
        }
        return jsonResultHelper.buildSuccessJsonResult(null);
    }
}
