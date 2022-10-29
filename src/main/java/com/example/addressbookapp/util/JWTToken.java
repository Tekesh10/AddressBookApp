package com.example.addressbookapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTToken {
    private static final String MESSAGE = "ACE";
    public String createToken(int id) {
        return JWT.create().withClaim("id", id).sign(Algorithm.HMAC256(MESSAGE));
    }
    public int parseJWT(String jwt) {
        int id = 0;
        if (jwt != null) {
            id = JWT.require(Algorithm.HMAC256(MESSAGE)).build().verify(jwt).getClaim("id").asInt();
        }
        return id;
    }
}