package com.dee.spring.testing.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dee.spring.testing.global.dao.ProductDao;
import com.dee.spring.testing.global.service.ProductService;
import com.dee.spring.testing.integration.dao.DefaultInMemoryProductDao;
import com.dee.spring.testing.integration.service.DefaultProductService;

/**
 * @author dien.nguyen
 **/

@Configuration
public class AppConfiguration {

    @Bean(name = "defaultInMemoryProductDao")
    public ProductDao productDao() {
        ProductDao productDao = new DefaultInMemoryProductDao();
        return productDao;
    }
    
    @Bean(name = "defaultProductService")
    public ProductService productService() {
        ProductService productService = new DefaultProductService();
        return productService;
    }
}
