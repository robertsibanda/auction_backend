package com.nx.auction_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nx.auction_backend.models.CustomUserDetails;
import com.nx.auction_backend.repo.UserRepo;

@Service
public class UserDetailsImpl implements UserDetailsService{

    private final UserRepo userRepo;

    public UserDetailsImpl(UserRepo repo) {
        this.userRepo = repo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByusername(username)
            .orElseThrow(() -> new UsernameNotFoundException("username not found"));
            return new CustomUserDetails(user);
    }
    
}
