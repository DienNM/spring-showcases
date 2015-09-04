package com.dee.web.spring.usecase1.service;

import java.util.List;

import com.dee.web.spring.usecase1.User;

/**
 * @author dien.nguyen
 **/

public interface UserService {
    
    void addUser(User user);
    
    List<User> getUsers();
}
