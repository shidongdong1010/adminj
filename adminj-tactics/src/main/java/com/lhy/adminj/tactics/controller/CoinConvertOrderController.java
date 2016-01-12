package com.lhy.adminj.tactics.controller;

import com.lhy.adminj.basic.common.ImgHandleService;
import com.lhy.adminj.basic.enumeration.CoinConvertGoodIsAddrEnum;
import com.lhy.adminj.basic.enumeration.CoinConvertOrderStatusEnum;
import com.lhy.adminj.basic.model.CoinConvertGood;
import com.lhy.adminj.basic.model.CoinConvertOrder;
import com.lhy.adminj.basic.service.CoinConvertGoodService;
import com.lhy.adminj.basic.service.CoinConvertOrderService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 兑换订单
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/17 15:31 Exp $
 */
@Controller
@RequestMapping("/tactics")
public class CoinConvertOrderController {
    @Autowired
    private CoinConvertGoodService coinConvertGoodService;

    @Autowired
    private CoinConvertOrderService coinConvertOrderService;

    @Autowired
    private JsonResultHelper jsonResultHelper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 兑换订单列表页
     * @return
     */
    @RequestMapping("/coinConvertOrderList.html")
    public String coinConvertOrderList(Long id, Model model){
        CoinConvertGood coinConvertGood =  coinConvertGoodService.findById(id);
        model.addAttribute("coinConvertGood", coinConvertGood);
        return "/tactics/coin/coinConvertOrderList";
    }

    /**
     * 兑换订单列表
     * @return
     */
    @RequestMapping("/coinConvertOrderList.json")
    @ResponseBody
    public Page<CoinConvertOrder> coinConvertOrderList(CoinConvertOrder coinConvertOrder, HttpServletRequest request){
        logger.info("兑换订单列表记录: {}", coinConvertOrder);

        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(coinConvertOrder);

        Page<CoinConvertOrder> page = PageUtil.getPage(request);

        // 统计总记录数
        page.setTotal(coinConvertOrderService.count(coinConvertOrder));
        // 分页记录
        List<CoinConvertOrder> list = coinConvertOrderService.find(coinConvertOrder, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    /**
     * 确认兑换订单
     * @param id
     * @param expressNo
     * @return
     */
    @RequestMapping("/makeCoinConvertOrder.json")
    @ResponseBody
    public JsonResult makeCoinConvertOrder(Long id, String expressNo, Long expressType, String expressAddr, String expressName, String expressMobile){
        CoinConvertOrder coinConvertOrder = coinConvertOrderService.findById(id);
        CoinConvertGood coinConvertGood =  coinConvertGoodService.findById(coinConvertOrder.getGoodId());

        // 使用地址
        if(CoinConvertGoodIsAddrEnum.getByCode(coinConvertGood.getIsAddr()).equals(CoinConvertGoodIsAddrEnum.Y)){
            coinConvertOrder.setExpressNo(expressNo);
            coinConvertOrder.setExpressType(expressType);
            coinConvertOrder.setExpressAddr(expressAddr);
            coinConvertOrder.setExpressName(expressName);
            coinConvertOrder.setExpressMobile(expressMobile);
        }
        coinConvertOrder.setStatus(CoinConvertOrderStatusEnum.Y.getCode());
        coinConvertOrderService.update(coinConvertOrder);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }
}
