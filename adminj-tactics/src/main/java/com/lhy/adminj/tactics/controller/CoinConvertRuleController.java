package com.lhy.adminj.tactics.controller;

import com.lhy.adminj.basic.enumeration.CoinConvertRuleIsEnableEnum;
import com.lhy.adminj.basic.model.CoinConvertRule;
import com.lhy.adminj.basic.service.CoinConvertRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * 航币兑换规则
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/16 20:01 Exp $
 */
@Controller
@RequestMapping("/tactics")
public class CoinConvertRuleController {

    @Autowired
    private CoinConvertRuleService coinConvertRuleService;

    /**
     * 查看
     * @param model
     * @return
     */
    @RequestMapping("/coinConvertRule.html")
    public String coinConvertRule(Model model){
        CoinConvertRule param = new CoinConvertRule();
        param.setIsEnable(CoinConvertRuleIsEnableEnum.Y.getCode());
        List<CoinConvertRule> list = coinConvertRuleService.find(param);
        CoinConvertRule coinConvertRule = list.get(0);
        model.addAttribute("coinConvertRule", coinConvertRule);
        return "/tactics/coin/coinConvertRule";
    }

    /**
     * 更新
     * @param coinConvertRule
     * @param model
     * @return
     */
    @RequestMapping("/submitCoinConvertRule.html")
    public String submitCoinConvertRule(CoinConvertRule coinConvertRule, Model model){
        CoinConvertRule param = new CoinConvertRule();
        param.setIsEnable(CoinConvertRuleIsEnableEnum.Y.getCode());
        List<CoinConvertRule> list = coinConvertRuleService.find(param);
        CoinConvertRule oldCoinConvertRule = list.get(0);

        // 有变化
        if(!coinConvertRule.getCoin().equals(oldCoinConvertRule.getCoin()) || !coinConvertRule.getRmb().equals(oldCoinConvertRule.getRmb())){
            // 将老的记录设置成无效
            oldCoinConvertRule.setEndTime(new Date());
            oldCoinConvertRule.setIsEnable(CoinConvertRuleIsEnableEnum.N.getCode());
            coinConvertRuleService.update(oldCoinConvertRule);
            // 插入新的记录
            coinConvertRule.setBeginTime(new Date());
            coinConvertRule.setIsEnable(CoinConvertRuleIsEnableEnum.Y.getCode());
            coinConvertRuleService.save(coinConvertRule);
        }

        return "redirect:coinConvertRule.html";
    }
}
