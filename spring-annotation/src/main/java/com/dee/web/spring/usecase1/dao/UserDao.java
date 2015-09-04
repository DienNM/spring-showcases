package com.dee.web.spring.usecase1.dao;

import java.util.List;

import com.dee.web.spring.usecase1.User;

/**
 * @author dien.nguyen
 **/

public interface UserDao {
    
    void save(User user);
    
    List<User> getAll();
    
}
