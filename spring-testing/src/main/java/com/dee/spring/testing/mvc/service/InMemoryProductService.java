package com.dee.spring.testing.mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.dee.spring.testing.global.exception.DuplicatedEntityException;
import com.dee.spring.testing.global.exception.EntityNotFoundException;
import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;

/**
 * @author dien.nguyen
 **/

@Service("inMemoryProductService")
public class InMemoryProductService implements ProductService {

    private ConcurrentMap<Long, Product> products = new ConcurrentHashMap<Long, Product>();
    
    @Override
    public Product get(Long id) {
        return products.get(id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public void add(Product product) {
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
    public void remove(Long id) {
        products.remove(id);
    }

}
