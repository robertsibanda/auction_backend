package com.nx.auction_backend.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nx.auction_backend.models.User;

public interface UserRepo extends MongoRepository<User, String>{
    Optional<User> findByusername(String username);
}
