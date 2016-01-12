package com.lhy.adminj.dynamic.controller;

import com.lhy.adminj.basic.model.Stock;
import com.lhy.adminj.basic.model.UserDynamicInfo;
import com.lhy.adminj.basic.service.StockService;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Administrator
 * @version $v: 1.0.0, $time:2015/10/10 13:18 Exp $
 */
@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping("/likeStock.json")
    @ResponseBody
    public Page<Stock> LikeStock(@RequestParam(value = "q", required=false) String stockCode, HttpServletRequest request){
        Page<Stock> page = PageUtil.getPage(request);

        // 统计总记录数
        page.setTotal(stockService.countLikeByStockCode(stockCode));
        // 分页记录
        List<Stock> list = stockService.findLikeByStockCode(stockCode, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
}
