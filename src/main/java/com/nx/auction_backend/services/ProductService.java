package com.nx.auction_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nx.auction_backend.models.Product;
import com.nx.auction_backend.repo.ProductRepo;


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    public List<Product> getAllProducts() {
        List<Product> aProducts = productRepo.findAll();
        return aProducts;
    }

    public Optional<Product> getProduct(String productId) {
        return productRepo.findById(productId); 

    }
}
