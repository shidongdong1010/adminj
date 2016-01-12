package com.lhy.adminj.basic.util.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 分页工具
 *
 * @author henryyan
 */
public class PageUtil {

    public static Long PAGE_SIZE = 15L;

    public static <T> Page<T> getPage(HttpServletRequest request) {
        Page<T> page = new Page<T>(PAGE_SIZE);
        // 当前页数
        String currPage = request.getParameter("page");
        // 判断每页显示记录数
        String pageSize = request.getParameter("rows");

        if (StringUtils.isNotBlank(currPage) && StringUtils.isNumeric(currPage)) {
            page.setPageNo(Long.parseLong(currPage));
        } else {
            page.setPageNo(1L);
        }
        if (StringUtils.isNotBlank(pageSize) && StringUtils.isNumeric(pageSize)) {
            page.setPageSize(Long.parseLong(pageSize));
        } else {
            page.setPageSize(PAGE_SIZE);
        }

        return page;
    }
}