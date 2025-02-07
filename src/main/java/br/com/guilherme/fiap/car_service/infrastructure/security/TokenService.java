package br.com.guilherme.fiap.car_service.infrastructure.security;

import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.UsuarioDocument;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public TokenResponse generateToken(UsuarioDocument usuario) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("veiculos-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

            return new TokenResponse("Bearer", token, generateExpirationDate());
        }catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("veiculos-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e) {
            return "";
        }
    }
}
