package com.dee.web.spring.usecase1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dee.web.spring.usecase1.User;
import com.dee.web.spring.usecase1.dao.UserDao;
import com.dee.web.spring.usecase1.other.IdGenerator;
import com.dee.web.spring.usecase1.service.UserService;

/**
 * @author dien.nguyen
 **/

@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private IdGenerator idGenerator;
    
    @Override
    public void addUser(User user) {
        user.setId(idGenerator.generate());
        userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

}
