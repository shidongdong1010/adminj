package com.lhy.adminj.sys.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 暂无用
 * @author Administrator
 * @version $v: 1.0.0, $time:2015/10/13 17:16 Exp $
 */
public class AppAccessDeniedHandler implements AccessDeniedHandler {

    public static String SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY = "SPRING_SECURITY_403_EXCEPTION";

    private String errorPage;


    public AppAccessDeniedHandler() {
    }

    public AppAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.sendRedirect(errorPage);
        String deniedMessage = accessDeniedException.getMessage();
        String rp = request.getRequestURI();
        request.getSession().setAttribute(SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY, deniedMessage);
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}