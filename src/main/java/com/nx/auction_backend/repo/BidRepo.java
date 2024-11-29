package com.nx.auction_backend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nx.auction_backend.models.Bid;

public interface BidRepo extends MongoRepository<Bid, String>{
    
}
