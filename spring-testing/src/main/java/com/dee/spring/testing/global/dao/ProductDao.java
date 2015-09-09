package com.dee.spring.testing.global.dao;

import java.util.List;

import com.dee.spring.testing.global.model.Product;

/**
 * @author dien.nguyen
 **/

public interface ProductDao {
    
    Product findById(Long id);
    
    List<Product> findAll();
    
    void insert(Product product);
    
    void update(Product product);
    
    void delete(Product product);
}
