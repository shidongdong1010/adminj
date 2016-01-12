package com.lhy.adminj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/12 19:37 Exp $
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}
