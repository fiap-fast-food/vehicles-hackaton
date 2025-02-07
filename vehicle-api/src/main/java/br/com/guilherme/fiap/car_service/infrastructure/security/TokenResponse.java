package br.com.guilherme.fiap.car_service.infrastructure.security;

import java.time.Instant;
import java.util.Date;

public class TokenResponse {

    private String tokenType;
    private String token;
    private Instant expires;

    public TokenResponse(String tokenType, String token, Instant expires) {
        this.tokenType = tokenType;
        this.token = token;
        this.expires = expires;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpires() {
        return expires;
    }

    public void setExpires(Instant expires) {
        this.expires = expires;
    }
}
