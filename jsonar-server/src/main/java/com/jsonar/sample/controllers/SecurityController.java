package com.jsonar.sample.controllers;

import com.jsonar.sample.exception.CoreException;
import com.jsonar.sample.models.security.TokenResponse;
import com.jsonar.sample.models.security.User;
import com.jsonar.sample.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Security operations")
public class SecurityController {
    @Autowired private UserService userService;

    @ApiOperation(value = "User can login to application and get token")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Everything is fine"),
            @ApiResponse(code=400, message="Bad request, something is wrong")
    })
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) throws CoreException {
        TokenResponse response = this.userService.findAuthorizedUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(response);
    }
}
