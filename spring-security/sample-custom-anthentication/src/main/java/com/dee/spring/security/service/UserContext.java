package com.dee.spring.security.service;

import com.dee.spring.security.model.DeeUser;

/**
 * @author dien.nguyen
 **/

public interface UserContext {
    
    DeeUser getCurrentUser();
    
    void setCurrentUser(DeeUser user);
    
}
