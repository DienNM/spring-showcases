package com.dee.spring.security.model.customize;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.util.DeeUserAuthorityUtil;

/**
 * @author dien.nguyen
 **/

public class DeeUserDetails extends DeeUser implements UserDetails {

    private static final long serialVersionUID = 1L;
    
    public DeeUserDetails() {
    }
    
    public DeeUserDetails(DeeUser deeUser) {
        setEmail(deeUser.getEmail());
        setEncrypted(deeUser.isEncrypted());
        setFirstName(deeUser.getFirstName());
        setLastName(deeUser.getLastName());
        setPassword(deeUser.getPassword());
        setRoles(deeUser.getRoles());
        setId(deeUser.getId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return DeeUserAuthorityUtil.createAuthorities(this);
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
