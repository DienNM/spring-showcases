package com.dee.spring.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.dee.spring.security.model.DeeUser;
import com.dee.spring.security.service.DeeUserService;

/**
 * @author dien.nguyen
 **/

@Service("inMemoryDeeUserService")
public class InMemoryDeeUserService implements DeeUserService {

    private static Map<String, DeeUser> deeUsers;

    @PostConstruct
    public void init() {
        deeUsers = new HashMap<String, DeeUser>();

        DeeUser admin = new DeeUser();
        admin.setId(1);
        admin.setEmail("admin@gmail.com");
        admin.setFirstName("Dien");
        admin.setLastName("Nguyen");
        admin.setEncrypted(false);
        admin.setPassword("admin");
        List<String> role1 = new ArrayList<String>();
        role1.add("ROLE_ADMIN");
        role1.add("ROLE_USER");
        admin.setRoles(role1);
        deeUsers.put(admin.getEmail(), admin);

        DeeUser user2 = new DeeUser();
        user2.setId(2);
        user2.setEmail("user1@gmail.com");
        user2.setFirstName("UF 1");
        user2.setLastName("UL 1");
        user2.setEncrypted(false);
        user2.setPassword("user1");
        List<String> role2 = new ArrayList<String>();
        role2.add("ROLE_USER");
        user2.setRoles(role2);
        deeUsers.put(user2.getEmail(), user2);

    }

    @Override
    public DeeUser getByEmail(String email) {
        return deeUsers.get(email);
    }

    @Override
    public DeeUser getById(long id) {
        for (DeeUser user : deeUsers.values()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(DeeUser user) {
        deeUsers.put(user.getEmail(), user);
    }

}
