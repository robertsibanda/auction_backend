package com.nx.auction_backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nx.auction_backend.models.Product;

public interface ProductRepo extends  MongoRepository<Product, String>{
    
}
