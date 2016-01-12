package com.lhy.adminj.sys.security;

import com.lhy.adminj.basic.enumeration.UUserIsLockedEnum;
import com.lhy.adminj.basic.model.UUser;
import com.lhy.adminj.basic.resultcode.UUserResultCode;
import com.lhy.adminj.basic.service.UUserService;
import com.lhy.springframework.web.util.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Administrator
 * @version $v: 1.0.0, $time:2015/10/13 14:44 Exp $
 */
public class AppLoginAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UUserService uUserService;
    @Autowired
    private MessageHelper messageHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            UUser uUser = uUserService.findByUserName(authentication.getName());
            if(uUser != null && uUser.getId() != null) {
                // 判断是帐号是否已经锁定
                if (UUserIsLockedEnum.getByCode(uUser.getIsLocked()).equals(UUserIsLockedEnum.LOCKED)) {
                    throw new LockedException(messageHelper.getMessage(UUserResultCode.LOGIN_ACCOUNT_LOCKED.getErrorCode()));
                }
            }

            Authentication auth = super.authenticate(authentication);

            // 重置登陆错误时间
            uUserService.resetFailAttempts(authentication.getName());
            return auth;
        } catch (BadCredentialsException e) {
            // 登陆出错+1
            UUser uUser = uUserService.updateFailAttempts(authentication.getName());
            if(uUser != null && uUser.getId() != null) {
                // 判断是帐号是否已经锁定
                if (UUserIsLockedEnum.getByCode(uUser.getIsLocked()).equals(UUserIsLockedEnum.LOCKED)) {
                    throw new LockedException(messageHelper.getMessage(UUserResultCode.LOGIN_ACCOUNT_LOCKED.getErrorCode()));
                }
            }
            // 剩于机会
            Long num = UUserService.MAX_ATTEMPTS - uUser.getLoginErrorCount();
            throw new BadCredentialsException(messageHelper.getMessage(UUserResultCode.LOGIN_PASSWORD_ERROR.getErrorCode(), new Object[]{num}));
        } catch (CredentialsExpiredException e){
            // 密码已过期
            throw new CredentialsExpiredException(messageHelper.getMessage(UUserResultCode.LOGIN_CREDENTIAL_EXPIRED.getErrorCode()));
        } catch (AuthenticationException e){
            e.printStackTrace();
            throw e;
        }
    }
}