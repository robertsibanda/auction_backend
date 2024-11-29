package com.nx.auction_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nx.auction_backend.services.BidService;

@RestController
public class BidController {
    
    @Autowired
    BidService bidService;
}
