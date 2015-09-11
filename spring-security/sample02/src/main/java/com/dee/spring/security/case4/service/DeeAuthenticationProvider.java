package com.dee.spring.security.case4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dee.spring.security.case4.dto.DomainUsernamePasswordAuthenticationToken;

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
        DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
        String name = token.getName();
        String domain = token.getDomain();
        
        String email = name + "@" + domain;
        
        UserDetails user = deeUserDetailsService.loadUserByUsername(email);
        String password = user.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new UsernameNotFoundException("Invalid  username/password");
        }
        return new DomainUsernamePasswordAuthenticationToken(user, user.getPassword(), domain, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return DomainUsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
