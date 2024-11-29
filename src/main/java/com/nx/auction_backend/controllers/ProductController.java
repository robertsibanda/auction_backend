package com.nx.auction_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nx.auction_backend.models.Product;
import com.nx.auction_backend.services.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;


    @GetMapping("/api/v1/products")
    List<Product> getAllProducts (){
        return productService.getAllProducts();
    }

    @GetMapping("/api/v1/product/{id}")
    Optional<Product> getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }
}
