package com.dee.spring.testing.integration.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.spring.testing.global.dao.ProductDao;
import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;

/**
 * @author dien.nguyen
 **/

@Service("defaultProductService")
public class DefaultProductService implements ProductService {
    
    @Autowired
    @Qualifier("defaultInMemoryProductDao")
    private ProductDao productDao;
    
    @PostConstruct
    public void init() {
        System.out.println("Initialized XmlProductService");
    }
    
    @Override
    public Product get(Long id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.insert(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void remove(Long id) {
        Product product = productDao.findById(id);
        if(product != null) {
            productDao.delete(product);
        }
    }

}
