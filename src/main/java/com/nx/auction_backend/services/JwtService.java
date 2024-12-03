package com.nx.auction_backend.services;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String SECRET_KEY = "eccd61df46f3450e64904eba8dfd6ea0bc2d875b1f6d334999086640caa3f78e";

    private  Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername (String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean isValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);

    }

    public  <T> T extractClaim(String token, Function <Claims, T > resolver) {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }


    public String generateToken(User user) {
        String token = Jwts
            .builder()
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
            .signWith(getSigningKey())
            .compact();

        return token;
    }

    private Key getSigningKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes);
    }
    
}
