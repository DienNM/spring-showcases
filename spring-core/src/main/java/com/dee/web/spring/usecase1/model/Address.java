package com.dee.web.spring.usecase1.model;

/**
 * @author dien.nguyen
 **/

public class Address {
    
    private String addressType;
    private String address;
    
    public Address() {
    }
    
    public Address(String addressType, String address) {
        this.address = address;
        this.addressType = addressType;
    }
    
    public String getAddressType() {
        return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
