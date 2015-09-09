package com.dee.spring.testing.integration.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.dee.spring.testing.global.dao.ProductDao;
import com.dee.spring.testing.global.exception.DuplicatedEntityException;
import com.dee.spring.testing.global.exception.EntityNotFoundException;
import com.dee.spring.testing.global.model.Product;

/**
 * @author dien.nguyen
 **/

@Repository("defaultInMemoryProductDao")
public class DefaultInMemoryProductDao implements ProductDao {
    
    private ConcurrentMap<Long, Product> products = new ConcurrentHashMap<Long, Product>();
    
    @PostConstruct
    public void init() {
        System.out.println("Initialized XmlInMemoryProductDao");
    }
    
    @Override
    public Product findById(Long id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public void insert(Product product) {
        if(products.containsKey(product.getId())) {
            throw new DuplicatedEntityException();
        }
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        if(!products.containsKey(product.getId())) {
            throw new EntityNotFoundException();
        }
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getId());
    }

}
