package com.dee.spring.testing.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dee.spring.testing.global.model.Product;
import com.dee.spring.testing.global.service.ProductService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    @Qualifier("inMemoryProductService")
    private ProductService productService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }
    
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String getProductDetail(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.get(productId);
        model.addAttribute("product", product);
        return "product_detail";
    }
    
}
