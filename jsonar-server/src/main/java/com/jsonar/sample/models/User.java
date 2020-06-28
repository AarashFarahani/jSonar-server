package com.jsonar.sample.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "Defines a user")
public class User {
    @ApiModelProperty(value = "Username", example = "Test1")
    private String username;

    @ApiModelProperty(value = "Password", example = "test1@mytest.com")
    private String password;
    private String token;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}