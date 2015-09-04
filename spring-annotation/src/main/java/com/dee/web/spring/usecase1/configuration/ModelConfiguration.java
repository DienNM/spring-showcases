package com.dee.web.spring.usecase1.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.dee.web.spring.usecase1.Address;
import com.dee.web.spring.usecase1.User;

/**
 * @author dien.nguyen
 **/

@Configuration
public class ModelConfiguration {
    
    @Bean
    @Scope("prototype")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("DienNM");
        
        Map<String, Address> addresses = new HashMap<String, Address>();
        addresses.put("home", new Address("home", "Tan Phu, Ho Chi Minh"));
        addresses.put("office", new Address("office", "Tan Binh, Ho Chi Minh"));
        
        Set<String> favourites = new HashSet<String>();
        favourites.add("Reading");
        favourites.add("Travelling");
        
        user.setAddresses(addresses);
        user.setFavourites(favourites);
        
        return user;
    }
    
}
