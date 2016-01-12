package com.lhy.adminj.basic.util.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 扩展spring security的user
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/14 10:28 Exp $
 */
public class AppUserDetail extends User{

    /** 用户ID **/
    private Long userId;
    /** 用户全称 **/
    private String fullname;

    public AppUserDetail(Long userId, String username, String fullname, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.fullname = fullname;
    }

    public AppUserDetail(Long userId, String username, String fullname, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.fullname = fullname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
