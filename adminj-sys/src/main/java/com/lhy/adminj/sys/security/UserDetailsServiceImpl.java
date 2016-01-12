package com.lhy.adminj.sys.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lhy.adminj.basic.enumeration.UUserIsEnableEnum;
import com.lhy.adminj.basic.enumeration.UUserIsExpiredEnum;
import com.lhy.adminj.basic.enumeration.UUserIsLockedEnum;
import com.lhy.adminj.basic.model.URole;
import com.lhy.adminj.basic.model.UUser;
import com.lhy.adminj.basic.resultcode.UUserResultCode;
import com.lhy.adminj.basic.service.URoleService;
import com.lhy.adminj.basic.service.UUserService;
import com.lhy.adminj.basic.util.security.AppUserDetail;
import com.lhy.adminj.basic.util.security.AuthUtil;
import com.lhy.springframework.web.util.MessageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * 用户相关权限
 *
 * @author SDD
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    private static Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UUserService uUserService;

    @Autowired
    private URoleService uRoleService;

    @Autowired
    private MessageHelper messageHelper;

    /**
     * @param userName 登录帐号
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("登录账号："+userName);
        org.springframework.security.core.userdetails.User userDetails = null;
        UUser user = uUserService.findByUserName(userName);
        if (user == null) {
            // 用户不存在
            throw new UsernameNotFoundException(messageHelper.getMessage(UUserResultCode.LOGIN_USER_NAME_NOT_EXISTS.getErrorCode(), new Object[]{userName}));
        }
        Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);

        boolean enables = true;

        // 帐户未失效
        boolean accountNonExpired = UUserIsEnableEnum.N.equals(UUserIsEnableEnum.getByCode(user.getIsEnable()));
        // 认证未失效
        boolean credentialsNonExpired = UUserIsExpiredEnum.N.equals(UUserIsExpiredEnum.getByCode(user.getIsExpired()));
        // 帐户未锁定
        boolean accountNonLocked = UUserIsLockedEnum.NORMAL.equals(UUserIsLockedEnum.getByCode(user.getIsLocked()));

        userDetails = new AppUserDetail(user.getId(), user.getUserName(), user.getFullname(), user.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return userDetails;
    }

    /**
     * 根据用户获取该用户拥有的角色
     * @param user
     * @return
     */
    private Set<GrantedAuthority> getGrantedAuthorities(UUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        List<URole> roles = uRoleService.findByUserId(user.getId());
        if(roles != null) {
            for(URole role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        // 添加登陆的角色
        grantedAuthorities.add(AuthUtil.ROLE_LOGIN);

        return grantedAuthorities;
    }

}