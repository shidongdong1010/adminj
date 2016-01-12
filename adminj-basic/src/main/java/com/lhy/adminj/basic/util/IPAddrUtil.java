package com.lhy.adminj.basic.util;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * @author SDD
 * @version $v: 1.0.0, $Id:IPAddrUtil.java, $time:2015/9/17 18:03 Exp $
 */
public class IPAddrUtil {

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
