package com.nx.auction_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "product")
@Data
public class Product {
    
    @Id
    private String id;
    private String title;
    private Double price;
    private String description;
    private String seller;
    private String imageUrl;
}
