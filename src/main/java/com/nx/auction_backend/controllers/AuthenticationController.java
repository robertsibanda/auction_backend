package com.nx.auction_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nx.auction_backend.models.AuthenticationResponse;
import com.nx.auction_backend.models.User;
import com.nx.auction_backend.services.AuthenticationService;

@RestController
public class AuthenticationController {
    
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
        @RequestBody User request
    ) 
    {
        System.out.println("\n\n\nTrying to register");
        System.out.println("Username : " + request.getUsername());
        System.out.println("Password : " + request.getPassword());
        System.out.println("firstname : " + request.getFirstname());
        System.out.println("Lastname : " + request.getLastname());
        System.out.println("Email : " + request.getEmail());
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
        @RequestBody User request
    ) {
        System.out.println("\n\n\nTrying to log in ");
        System.out.println("Username : " + request.getUsername());
        System.out.println("Password : " + request.getPassword());
        System.out.println("firstname : " + request.getFirstname());
        System.out.println("Lastname : " + request.getLastname());
        System.out.println("Email : " + request.getEmail());
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    
}
