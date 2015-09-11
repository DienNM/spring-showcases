package com.dee.spring.security.case3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dien.nguyen
 **/

@Service("deeAuthenticationProvider")
public class DeeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("deeUserDetailsService")
    private DeeUserDetailsService deeUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String email = token.getName();
        UserDetails user = deeUserDetailsService.loadUserByUsername(email);
        String password = user.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new UsernameNotFoundException("Invalid  username/password");
        }
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
