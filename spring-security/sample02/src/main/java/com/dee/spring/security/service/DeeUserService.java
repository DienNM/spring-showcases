package com.dee.spring.security.service;

import com.dee.spring.security.model.DeeUser;

/**
 * @author dien.nguyen
 **/

public interface DeeUserService {
    
    DeeUser getByEmail(String email);
    
    DeeUser getById(long id);
    
    void add(DeeUser user);
    
}
