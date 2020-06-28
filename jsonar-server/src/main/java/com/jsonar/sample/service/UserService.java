package com.jsonar.sample.service;

import com.jsonar.sample.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Value("${security.jwt.token.secret-key}") private String secretKey;
    @Value("${security.jwt.token.expiration}") private long validityInMinutes;

    private List<User> users = Arrays.asList(
            new User("Test1", "test1@mytest.com"),
            new User("Test2", "test2@mytest.com"));

    public Optional<User> findUser(String username) {
        return this.users.stream()
                .filter(a-> a.getUsername().equalsIgnoreCase(username))
                .findAny();
    }

    public User findAuthorizedUser(String username, String password) throws Exception {
        User user = this.users.stream()
                    .filter(a-> a.getUsername().equalsIgnoreCase(username))
                    .findAny()
                    .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        //In real application, check password in hash format
        if (!user.getPassword().equals(password)) {
            throw new Exception("Password is incorrect");
        }

        user = new User(username, "");//in response we don't need password
        user.setToken(this.createToken(username, "admin"));
        return user;
    }

    private String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", new SimpleGrantedAuthority(role));

        Date now = new Date();
        LocalDateTime dateTime = LocalDateTime.now().plus(Duration.of(this.validityInMinutes, ChronoUnit.MINUTES));
        Date validity = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
