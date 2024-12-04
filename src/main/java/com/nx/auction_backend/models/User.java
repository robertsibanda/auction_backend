package com.nx.auction_backend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nx.auction_backend.services.UserDetailsImpl;

import lombok.Data;

@Document(collection = "user")
@Data
public class User implements UserDetailsService{
    
    @Id
    private String userid;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    Role role;

    @Autowired
    UserDetailsImpl userDetailsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsService.loadUserByUsername(username);
    }

}
