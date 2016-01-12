package com.lhy.adminj.sys.controller;

import com.lhy.adminj.basic.enumeration.UMenuIsLeafEnum;
import com.lhy.adminj.basic.model.UMenu;
import com.lhy.adminj.basic.service.UMenuService;
import com.lhy.adminj.basic.util.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * 菜单
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/9 9:07 Exp $
 */
@Controller
@RequestMapping("/treeMenu")
public class TreeMenuController {

    @Autowired
    private UMenuService menuService;

    @RequestMapping(value = "/tree.json")
    @ResponseBody
    public List<UMenu> tree(){
        Long userId = AuthUtil.getUserId();
        List<UMenu> list = menuService.find(userId);

        // 去掉无子菜单的菜单
        List<UMenu> removes = new ArrayList<UMenu>();
        for(UMenu uMenu : list){
            if(UMenuIsLeafEnum.getByCode(uMenu.getIsLeaf()).equals(UMenuIsLeafEnum.N)){
                // 判断是否有子节点
                if(!isHaveLeaf(list, uMenu.getId())){
                    removes.add(uMenu);
                }
            }
        }
        list.removeAll(removes);
        return list;
    }

    // 判断是否有子菜单
    private boolean isHaveLeaf(List<UMenu> list, Long parentId){
        for(UMenu uMenu : list){
            if(uMenu.getParentId().equals(parentId)){
                return true;
            }
        }
        return false;
    }
}
