package com.dee.spring.testing.integration.xml.case1;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dee.spring.testing.global.exception.DuplicatedEntityException;
import com.dee.spring.testing.global.exception.EntityNotFoundException;
import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;
import com.dee.spring.testing.integration.xml.IntegrationSpringTestNGTestCase1;

/**
 * @author dien.nguyen
 **/

public class ProductServiceTestNGTest extends IntegrationSpringTestNGTestCase1 {
    
    private final static Long ID_SAVED = 1L;
    private final static Long ID_TRANS = 2L;
    
    @Autowired
    private ProductService productService;
    
    private Product productSaved;
    
    @BeforeMethod
    public void init() {
        productSaved = new Product();
        productSaved.setId(ID_SAVED);
        productSaved.setName("Product 1");
        productSaved.setQuantity(1);
        productService.add(productSaved);
        
    }
    
    @AfterMethod
    public void destroy() {
        productService.remove(ID_SAVED);
        productService.remove(ID_TRANS);
    }
    
    @DataProvider(name = "illegalData4Save")
    public Object[][] illegalData4Save() {
        return new Object[][] {new Object[] {productSaved}};
    }
    
    @DataProvider(name = "legalData4Save")
    public Object[][] legalData4Save() {

        Product productTransient = new Product();
        productTransient.setId(2L);
        productTransient.setName("Product 2");
        productTransient.setQuantity(2);
        
        return new Object[][] {new Object[] {productTransient}};
    }
    
    @Test(dataProvider = "illegalData4Save",  expectedExceptions = DuplicatedEntityException.class)
    public void saveIllegal(Product product) {
        productService.add(product);
    }
    
    @Test(dataProvider = "legalData4Save")
    public void save(Product product) {
        productService.add(product);
        Assert.assertNotNull(productService.get(product.getId()));
        Assert.assertEquals("Product 2", productService.get(product.getId()).getName());
        Assert.assertEquals(2, productService.get(product.getId()).getQuantity());
    }
    
    @Test(expectedExceptions = EntityNotFoundException.class)
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
