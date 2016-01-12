package com.lhy.adminj.sys.security;


import com.lhy.adminj.basic.util.password.PasswordUtil;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * @author Administrator
 * @version $v: 1.0.0, $time:2015/10/13 11:26 Exp $
 */
public class AppPasswordEncoder  implements PasswordEncoder{

    @Override
    public String encodePassword(String s, Object o) {
        return s;
    }

    @Override
    public boolean isPasswordValid(String s, String s1, Object o) {
        return PasswordUtil.equals(s1, s);
    }
}
