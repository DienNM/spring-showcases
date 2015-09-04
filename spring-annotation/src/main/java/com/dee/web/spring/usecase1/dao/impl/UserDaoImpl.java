package com.dee.web.spring.usecase1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dee.web.spring.usecase1.User;
import com.dee.web.spring.usecase1.dao.UserDao;

/**
 * @author dien.nguyen
 **/

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    
    private List<User> users = new ArrayList<User>();
    
    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
    

}
