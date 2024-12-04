package com.nx.auction_backend.models;

import lombok.Data;

@Data
public class AuthenticationResponse {
    
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }
}
