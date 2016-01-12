package com.lhy.adminj.sys.controller;

import com.lhy.adminj.basic.enumeration.UMenuIsLeafEnum;
import com.lhy.adminj.basic.model.UMenu;
import com.lhy.adminj.basic.service.UMenuService;
import com.lhy.adminj.basic.service.UUserRoleService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜单Controller
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/16 13:14 Exp $
 */
@Controller
@RequestMapping("/sys/uMenu")
public class UMenuController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UMenuService uMenuService;
    @Autowired
    private UUserRoleService uUserRoleService;
    @Autowired
    private JsonResultHelper jsonResultHelper;

    /**
     * 菜单列表页
     * @return
     */
    @RequestMapping("/menuList.html")
    public String userList(){
        return "/sys/uMenu/menuList";
    }

    /**
     * 菜单列表页
     * @return
     */
    @RequestMapping("/menuList.json")
    @ResponseBody
    public Page<UMenu> userList(UMenu menu, HttpServletRequest request){
        logger.info("forward----------------- 用户列表页");
        Page<UMenu> page = PageUtil.getPage(request);
        ObjectUtil.nullStringConverNull(menu);
        String sql ="";
        // 统计总记录数
        page.setTotal(uMenuService.count(menu));
        // 分页记录
        List<UMenu> list = uMenuService.find(menu, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    @RequestMapping("/saveMenu.json")
    @ResponseBody
    public JsonResult saveMenu(@RequestBody List<Map<String, Object>> menus){
        for(Map<String, Object> m : menus) {
            String action = m.get("action").toString();
            UMenu menu = new UMenu();
            menu.setId(m.get("id") == null ? null : Long.parseLong(m.get("id").toString()));
            menu.setName(m.get("name") == null ? null : m.get("name").toString());
            menu.setUrl(m.get("url") == null ? null : m.get("url").toString());
            menu.setSort(m.get("sort") == null ? null : Long.parseLong(m.get("sort").toString()));
            menu.setIsEnable(m.get("isEnable") == null ? null : Long.parseLong(m.get("isEnable").toString()));
            menu.setIsLeaf(m.get("isLeaf") == null ? null : Long.parseLong(m.get("isLeaf").toString()));
            menu.setLevel(m.get("level") == null ? null : Long.parseLong(m.get("level").toString()));
            menu.setParentId(m.get("parentId") == null ? null : Long.parseLong(m.get("parentId").toString()));

            if (action.equals("update")) {
                uMenuService.update(menu);
            } else if (action.equals("insert")) {
                UMenu parentMenu = uMenuService.findById(menu.getParentId());
                if(parentMenu != null && UMenuIsLeafEnum.getByCode(parentMenu.getIsLeaf()).equals(UMenuIsLeafEnum.Y)) {
                    // 更新父节点为非子节点
                    parentMenu.setIsLeaf(UMenuIsLeafEnum.N.getCode());
                    uMenuService.update(parentMenu);
                }
                menu.setLevel(parentMenu.getLevel() + 1);
                menu.setIsLeaf(1L); // 叶子节点
                uMenuService.save(menu);
            } else if (action.equals("delete")) {
                uMenuService.delete(menu.getId());
            }
        }
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    @RequestMapping("/batchUpdateMenu.json")
    @ResponseBody
    public JsonResult batchUpdateMenu(@RequestParam("id") Long[] ids, @RequestParam("name") String[] names, @RequestParam("url") String[] urls,
                                      @RequestParam("sort") Long[] sorts, @RequestParam("isEnable") Long[] isEnables){

        List<UMenu> list = new ArrayList<UMenu>();
        for(int i = 0; i < ids.length; i++){
            Long id = ids[i];
            UMenu uMenu = uMenuService.findById(id);
            uMenu.setName(names[i]);
            uMenu.setUrl(urls[i]);
            uMenu.setSort(sorts[i]);
            uMenu.setIsEnable(isEnables[i]);
            list.add(uMenu);
        }
        uMenuService.batchUpdate(list);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

}
