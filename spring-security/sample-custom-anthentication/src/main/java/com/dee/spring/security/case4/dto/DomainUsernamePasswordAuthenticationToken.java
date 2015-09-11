package com.dee.spring.security.case4.dto;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author dien.nguyen
 **/

public class DomainUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    private String domain;

    public DomainUsernamePasswordAuthenticationToken(String principal, String credentials, String domain) {
        super(principal, credentials);
        this.domain = domain;
    }

    public DomainUsernamePasswordAuthenticationToken(UserDetails principal, String credentials, String domain,
            Collection<? extends GrantedAuthority> roles) {
        super(principal, credentials, roles);
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

}
