package com.dee.spring.testing.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;

/**
 * @author dien.nguyen
 **/

@WebAppConfiguration
public class ProductControllerTest extends MvcSpringJUnit4Test {

    private final static Long ID_SAVED = 1L;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    @Qualifier("inMemoryProductService")
    private ProductService productService;
    
    private MockMvc mockMvc;
    private Product product1;
    
    @Before
    public void init() {
        product1 = new Product();
        product1.setId(ID_SAVED);
        product1.setName("Product 1");
        product1.setQuantity(1);
        productService.add(product1);
        
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @After
    public void destroy() {
        productService.remove(ID_SAVED);
    }
    
    @Test
    public void getAllProducts() throws Exception{
        MvcResult result = mockMvc.perform(get("/products"))
                   .andDo(MockMvcResultHandlers.print())
                   .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/products.jsp"))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertTrue(model.containsKey("products"));
    }
    
    @Test
    public void getProduct() throws Exception{
        MvcResult result = mockMvc.perform(get("/products/1"))
                   .andDo(MockMvcResultHandlers.print())
                   .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/product_detail.jsp"))
                   .andExpect(MockMvcResultMatchers.status().isOk())
                   .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertTrue(model.containsKey("product"));
    }
}
