package com.codecool.mavens.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.sql.Ref;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtil {

    private static final String SECRET_KEY = "secretsecretsecretsecretsecretsecretsecret";
    private static final int REFRESH_EXPIRATION = 14 * 24 * 60 * 60 * 1000;
    private static final int ACCESS_EXPIRATION = 30 * 60 * 1000;

    private Algorithm generateAlgorithm(){
        return Algorithm.HMAC256(SECRET_KEY.getBytes());
    }

    public String generateAccessToken(User user, String url){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION))
                .withIssuer(url)
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(generateAlgorithm());
    }
    public String generateRefreshToken(User user, String url){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION))
                .withIssuer(url)
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(generateAlgorithm());
    }

    public DecodedJWT getDecodedJwt(String token){
        JWTVerifier verifier = JWT.require(generateAlgorithm()).build();
        return verifier.verify(token);
    }

}
