package com.lhy.adminj.sys.controller;

import com.lhy.adminj.basic.enumeration.UUserIsEnableEnum;
import com.lhy.adminj.basic.enumeration.UUserIsLockedEnum;
import com.lhy.adminj.basic.model.URole;
import com.lhy.adminj.basic.model.UUser;
import com.lhy.adminj.basic.model.UUserRole;
import com.lhy.adminj.basic.resultcode.UUserResultCode;
import com.lhy.adminj.basic.service.URoleService;
import com.lhy.adminj.basic.service.UUserRoleService;
import com.lhy.adminj.basic.service.UUserService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.password.PasswordUtil;
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
 * 系统用户管理
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/15 15:31 Exp $
 */
@Controller
@RequestMapping("/sys/uUser")
public class UUserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UUserService uUserService;
    @Autowired
    private URoleService uRoleService;
    @Autowired
    private UUserRoleService uUserRoleService;
    @Autowired
    private JsonResultHelper jsonResultHelper;

    @RequestMapping("/testJta.html")
    public String testJta(){
        uUserService.testJta();
        return null;
    }

    /**
     * 用户列表页
     * @return
     */
    @RequestMapping("/userList.html")
    public String userList(){
        return "/sys/uUser/userList";
    }

    /**
     * 用户列表页
     * @return
     */
    @RequestMapping("/userList.json")
    @ResponseBody
    public Page<UUser> userList(UUser user, HttpServletRequest request){
        logger.info("forward----------------- 用户列表页");
        Page<UUser> page = PageUtil.getPage(request);
        ObjectUtil.nullStringConverNull(user);
        String sql ="";
        // 统计总记录数
        page.setTotal(uUserService.count(user));
        // 分页记录
        List<UUser> list = uUserService.find(user, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }


    /**
     * 用户管理--增加用户前
     * @return
     * @throws Exception
     */
    @RequestMapping(value="addUser.html")
    public String addUser(Model model) throws Exception {
        // 查询所有的角色
        List<URole> allrolelist = uRoleService.find(null);
        model.addAttribute("allrolelist", allrolelist);
        return "/sys/uUser/addUser";
    }

    /**
     * 用户管理--添加用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value="addUser.json")
    @ResponseBody
    public JsonResult addUser(UUser user, Long[] roleId) throws Exception {
        uUserService.addUser(user, roleId);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 用户管理--修改用户前
     * @return
     * @throws Exception
     */
    @RequestMapping(value="updateUser.html")
    public String updateUser(Long userId, Model model) throws Exception {
        // 查询用户信息
        UUser uUser = uUserService.findById(userId);
        model.addAttribute("user", uUser);

        // 查询用户的角色
        List<UUserRole> uUserRoles = uUserRoleService.findByUserId(userId);
        model.addAttribute("userRoles", uUserRoles);

        // 查询所有的角色
        List<URole> allrolelist = uRoleService.find(null);
        model.addAttribute("allrolelist", allrolelist);
        return "/sys/uUser/updateUser";
    }

    /**
     * 用户管理--修改
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value="updateUser.json")
    @ResponseBody
    public JsonResult updateUser(UUser user, Long[] roleId) throws Exception {
        // 验证用户不是否重复
        UUser uUser = uUserService.findByUserName(user.getUserName());
        if(uUser != null && !uUser.getId().equals(user.getId())){
            return jsonResultHelper.buildFailJsonResult(UUserResultCode.LOGIN_USER_NAME_ESISTS);
        }
        uUserService.updateUser(user, roleId);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 修改密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateUserPwd.json")
    @ResponseBody
    public JsonResult updateUserPwd(Long userId, String oldPassword, String password) throws Exception {
        logger.info("修改密码, {}", userId);
        // 查询用户信息
        UUser uUser = uUserService.findById(userId);
        if(!PasswordUtil.equals(oldPassword, uUser.getPassword())){  // 验证密码是否相同
            return jsonResultHelper.buildFailJsonResult(UUserResultCode.LOGIN_PASSWORD_ERROR2);
        }
        uUser.setPassword(PasswordUtil.encode(password));
        uUserService.update(uUser);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 重置密码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resetUserPwd.json")
    @ResponseBody
    public JsonResult resetUserPwd(Long userId, String password) throws Exception {
        logger.info("重置密码, {}", userId);
        // 查询用户信息
        UUser uUser = uUserService.findById(userId);
        uUser.setPassword(PasswordUtil.encode(password));
        uUserService.update(uUser);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }


    /**
     * 锁定用户
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "lockUser.json")
    @ResponseBody
    public JsonResult lockUser(Long userId) throws Exception {
        logger.info("锁定用户, {}", userId);
        // 查询用户信息
        UUser uUser = uUserService.findById(userId);
        if(UUserIsLockedEnum.getByCode(uUser.getIsLocked()).equals(UUserIsLockedEnum.LOCKED)){
            uUser.setIsLocked(UUserIsLockedEnum.NORMAL.getCode());
        }else {
            uUser.setIsLocked(UUserIsLockedEnum.LOCKED.getCode());
        }
        uUserService.update(uUser);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 注销用户
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteUser.json")
    @ResponseBody
    public JsonResult deleteUser(Long userId) throws Exception {
        logger.info("注销用户, {}", userId);
        // 查询用户信息
        UUser uUser = uUserService.findById(userId);
        if(UUserIsEnableEnum.getByCode(uUser.getIsEnable()).equals(UUserIsEnableEnum.Y)){
            uUser.setIsEnable(UUserIsEnableEnum.N.getCode());
        }else {
            uUser.setIsEnable(UUserIsEnableEnum.Y.getCode());
        }
        uUserService.update(uUser);
        return jsonResultHelper.buildSuccessJsonResult(null);
    }
}
