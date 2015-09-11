package com.dee.spring.security.case3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dee.spring.security.case3.dto.DeeUserDetails;
import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;

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
        return new DeeUserDetails(deeUser);
    }

}
