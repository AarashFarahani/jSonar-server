package com.jsonar.sample.controllers;

import com.jsonar.sample.models.User;
import com.jsonar.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @Autowired private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) throws Exception {
        User authorizedUser = this.userService.findAuthorizedUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(authorizedUser);
    }
}
