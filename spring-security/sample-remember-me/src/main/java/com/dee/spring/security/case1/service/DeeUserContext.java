package com.dee.spring.security.case1.service;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.UserContext;
import com.dee.spring.security.util.DeeUserAuthorityUtil;

/**
 * @author dien.nguyen
 **/

@Service("deeUserContext")
public class DeeUserContext implements UserContext {
    
    @Override
    public DeeUser getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authen = securityContext.getAuthentication();
        if(authen == null) {
            return null;
        }
        return (DeeUser) authen.getPrincipal();
    }

    @Override
    public void setCurrentUser(DeeUser user) {
        List<GrantedAuthority> grantedAuthorities = DeeUserAuthorityUtil.createAuthorities(user);
        Authentication authentication = new 
                UsernamePasswordAuthenticationToken(user, user.getPassword(), grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
