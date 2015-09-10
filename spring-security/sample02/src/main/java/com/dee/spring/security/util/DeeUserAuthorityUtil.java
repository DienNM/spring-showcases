package com.dee.spring.security.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.dee.spring.security.model.DeeUser;

/**
 * @author dien.nguyen
 **/

public final class DeeUserAuthorityUtil {

    public static List<GrantedAuthority> createAuthorities(DeeUser user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for(String role : user.getRoles()) {
            GrantedAuthority ga = new SimpleGrantedAuthority(role);
            grantedAuthorities.add(ga);
        }
        return grantedAuthorities;
    }
    
}
