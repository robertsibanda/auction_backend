package com.nx.auction_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "bid")
@Data
public class Bid {

    @Id
    private String id;
    private String userid;
    private String productId;
    private Double bidPrice;
}
