package com.dee.spring.testing.integration.xml.case2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dee.spring.testing.global.exception.DuplicatedEntityException;
import com.dee.spring.testing.global.exception.EntityNotFoundException;
import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;
import com.dee.spring.testing.integration.xml.IntegrationSpringJUnit4TestCase2;

/**
 * @author dien.nguyen
 **/

public class ProductServiceJUnit4Test extends IntegrationSpringJUnit4TestCase2 {
    
    private final static Long ID_SAVED = 1L;
    private final static Long ID_TRANS = 2L;
    
    @Autowired
    private ProductService productService;
    
    private Product productSaved;
    private Product productTransient;
    
    @Before
    public void init() {
        productSaved = new Product();
        productSaved.setId(ID_SAVED);
        productSaved.setName("Product 1");
        productSaved.setQuantity(1);
        productService.add(productSaved);
        
        productTransient = new Product();
        productTransient.setId(ID_TRANS);
        productTransient.setName("Product 2");
        productTransient.setQuantity(2);
    }
    
    @After
    public void destroy() {
        productService.remove(ID_SAVED);
        productService.remove(ID_TRANS);
    }
    
    @Test(expected = DuplicatedEntityException.class)
    public void saveIllegal() {
        productService.add(productSaved);
    }
    
    @Test
    public void save() {
        productService.add(productTransient);
        Assert.assertNotNull(productService.get(ID_TRANS));
        Assert.assertEquals("Product 2", productService.get(ID_TRANS).getName());
        Assert.assertEquals(2, productService.get(ID_TRANS).getQuantity());
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void updateIllegal() {
        Product productNotFound = new Product();
        productNotFound.setId(3L);
        productService.update(productNotFound);
    }
    
    @Test
    public void update() {
        Product product = productService.get(ID_SAVED);
        Assert.assertNotNull(product);
        Assert.assertEquals("Product 1", product.getName());
        Assert.assertEquals(1, product.getQuantity());
        
        // Update
        product.setQuantity(3);
        product.setName("Product");
        productService.update(product);
        product = productService.get(ID_SAVED);
        Assert.assertNotNull(product);
        Assert.assertEquals("Product", product.getName());
        Assert.assertEquals(3, product.getQuantity());
    }
    
    @Test
    public void delete() {
        Product product = productService.get(ID_SAVED);
        Assert.assertNotNull(product);
        
        productService.remove(product.getId());
        product = productService.get(ID_SAVED);
        Assert.assertNull(product);
    }
    
}
