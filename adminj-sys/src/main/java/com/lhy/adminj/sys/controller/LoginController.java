package com.lhy.adminj.sys.controller;

import com.lhy.adminj.basic.model.UUser;
import com.lhy.adminj.basic.service.UUserService;
import com.lhy.adminj.sys.security.AppAccessDeniedHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.AccessDeniedException;

/**
 * 登陆
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/12 19:17 Exp $
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UUserService uUserService;

    @RequestMapping("/login.html")
    public String login(Integer error, Model model) {
        if (error != null) {
            return "login";
        }
        /*
        if(StringUtils.isBlank(userName)){
            model.addAttribute("msg", "用户名不能为空");
            return "login";
        }

        if(StringUtils.isBlank(password)){
            model.addAttribute("msg", "密码不能为空");
            return "login";
        }

        UUser uUser = uUserService.findByUserName(userName);
        if(uUser == null || uUser.getId() == null) {
            model.addAttribute("msg", "用户不存在");
            return "login";
        }
        if(uUser.getPassword().equals(password)){
            // 登陆成功
            userDetailsService.loadUserByUsername(userName);
            return "redirect:index.html";
        }
        */
        return "login";
    }
}
