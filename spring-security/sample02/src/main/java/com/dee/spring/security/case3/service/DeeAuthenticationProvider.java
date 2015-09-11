package com.dee.spring.security.case3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;
import com.dee.spring.security.util.DeeUserAuthorityUtil;

/**
 * @author dien.nguyen
 **/

@Service("deeAuthenticationProvider")
public class DeeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private DeeUserService deeUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String email = token.getName();
        DeeUser user = deeUserService.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid  username/password");
        }

        String password = user.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new UsernameNotFoundException("Invalid  username/password");
        }
        List<GrantedAuthority> roles = DeeUserAuthorityUtil.createAuthorities(user);
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), roles);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
