package com.jsonar.sample.models.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TokenResponse", description = "Defines a Token response")
public class TokenResponse {
    @ApiModelProperty(value = "Username", example = "Test1")
    private String username;
    @ApiModelProperty(value = "Token", example = "Somethin like this 'sdfgerr4tcerert5vew'")
    private String token;

    public TokenResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
