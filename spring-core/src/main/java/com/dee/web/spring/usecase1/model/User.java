package com.dee.web.spring.usecase1.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.dee.web.spring.usecase1.UserType;


/**
 * @author dien.nguyen
 **/

public class User {
    
    private String id;
    
    private String name;
    
    private UserType userType;
    
    private Set<String> favourites;
    
    private Map<String, Address> addresses;
    
    private List<String> phones;
    
    private Properties training;
    
    public User() {
    }
    
    public User(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<String> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<String> favourites) {
        this.favourites = favourites;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Properties getTraining() {
        return training;
    }

    public void setTraining(Properties training) {
        this.training = training;
    }

}
