package com.dee.web.spring.usecase1;

import java.util.Map;
import java.util.Set;


/**
 * @author dien.nguyen
 **/

public class User {
    
    private String id;
    
    private String name;
    
    private Set<String> favourites;
    
    private Map<String, Address> addresses;
    
    public User() {
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

}
