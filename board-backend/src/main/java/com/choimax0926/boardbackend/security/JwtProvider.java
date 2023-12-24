package com.choimax0926.boardbackend.security;

import org.springframework.beans.factory.annotation.Value;

import java.security.Key;

public class JwtProvider {

    @Value("${jwt.accessToken.duration}")
    public Long jwtAccessTokenDuration;

    @Value("${jwt.refreshToken.duration}")
    public Long jwtRefreshTokenDuration;

    @Value("${jwt.email.auth.duration}")
    public Long jwtEmailAuthTokenDuration;

    @Value("${jwt.secret}")
    private String secret;

    private Key secretKey;
}
