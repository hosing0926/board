package com.choimax0926.boardbackend.security;

import com.choimax0926.boardbackend.entity.constant.Role;
import com.choimax0926.boardbackend.exception.ApiException;
import com.choimax0926.boardbackend.exception.constant.Error;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtProvider {

    private final JwtUtil jwtUtil;

    @Value("${jwt.accessToken.duration}")
    public Long jwtAccessTokenDuration;

    @Value("${jwt.refreshToken.duration}")
    public Long jwtRefreshTokenDuration;

    @Value("${jwt.email.auth.duration}")
    public Long jwtEmailAuthTokenDuration;

    public Authentication getAuthentication(String token) {
        Claims claims = validateToken(token);
        if (claims == null) throw new ApiException(Error.TOKEN_VALID_FAILED);

        return userPrincipal(claims);
    }

    public Claims validateToken(String token) {
        Claims claims = jwtUtil.validateToken(token);
        if (claims == null) throw new ApiException(Error.TOKEN_VALID_FAILED);

        return claims;
    }

    public Claims validateRefreshToken(String token) {
        Claims claims = jwtUtil.validateRefreshToken(token);
        if (claims == null) throw new ApiException(Error.TOKEN_VALID_FAILED);

        return claims;
    }

    public String generateAccessToken(String id, Role role) {
        Date now = new Date();
        Date expiration = new Date(System.currentTimeMillis() + jwtAccessTokenDuration);

        return jwtUtil.generateToken(id, role, now, expiration);
    }

    public String generateRefreshToken() {
        Date now = new Date();
        Date expiration = new Date(System.currentTimeMillis() + jwtRefreshTokenDuration);

        return jwtUtil.generateToken(null, null, now, expiration);
    }

    public String generateEmailAuthToken() {
        Date now = new Date();
        Date expiration = new Date(System.currentTimeMillis() + jwtEmailAuthTokenDuration);

        return jwtUtil.generateToken(null, null, now, expiration);
    }

    private UsernamePasswordAuthenticationToken userPrincipal(Claims claims) {
        Collection<? extends GrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority(claims.get("role").toString()));
        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", principal.getAuthorities());
    }
}
