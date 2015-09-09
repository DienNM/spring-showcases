package com.dee.spring.testing.global.service;

import java.util.List;

import com.dee.spring.testing.global.model.Product;

/**
 * @author dien.nguyen
 **/

public interface ProductService {
    
    Product get(Long id);
    
    List<Product> getAll();
    
    void add(Product product);
    
    void update(Product product);
    
    void remove(Long id);
    
}
