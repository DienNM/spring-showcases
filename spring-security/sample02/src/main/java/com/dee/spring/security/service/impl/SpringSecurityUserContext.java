package com.dee.spring.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;
import com.dee.spring.security.service.UserContext;
import com.dee.spring.security.util.DeeUserAuthorityUtil;

/**
 * @author dien.nguyen
 **/

@Service("springSecurityUserContext")
public class SpringSecurityUserContext implements UserContext {
    
    @Autowired
    private DeeUserService deeUserService;

    @Override
    public DeeUser getCurrentUser() {
        
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authen = securityContext.getAuthentication();
        if(authen == null) {
            return null;
        }
        return deeUserService.getByEmail(authen.getName());
    }

    @Override
    public void setCurrentUser(DeeUser user) {
        List<GrantedAuthority> grantedAuthorities = DeeUserAuthorityUtil.createAuthorities(user);
        UserDetails userDetail = new User(user.getEmail(), user.getPassword(), grantedAuthorities);
        Authentication authentication = new 
                UsernamePasswordAuthenticationToken(userDetail, userDetail.getPassword(), userDetail.getAuthorities());
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
