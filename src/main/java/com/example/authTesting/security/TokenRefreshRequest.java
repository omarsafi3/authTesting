package com.example.authTesting.security;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenRefreshRequest {

    private String refreshToken;

}