package com.dee.spring.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;
import com.dee.spring.security.util.DeeUserAuthorityUtil;

/**
 * @author dien.nguyen
 **/

@Service("deeUserDetailsService")
public class DeeUserDetailsService implements UserDetailsService{
    
    @Autowired
    private DeeUserService deeUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DeeUser deeUser = deeUserService.getByEmail(email);
        if(deeUser == null) {
            throw new UsernameNotFoundException("Invalid username/password.");
        }

        List<GrantedAuthority> grantedAuthorities = DeeUserAuthorityUtil.createAuthorities(deeUser);
        return new User(deeUser.getEmail(), deeUser.getPassword(), grantedAuthorities);
    }

}
