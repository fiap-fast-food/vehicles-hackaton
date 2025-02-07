package br.com.guilherme.fiap.car_service.api.controller;

import br.com.guilherme.fiap.car_service.api.request.authenticate.AuthenticationRequest;
import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.UsuarioDocument;
import br.com.guilherme.fiap.car_service.infrastructure.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Tag(name = "login", description = "Realizar login e obter token jwt")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest request) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UsuarioDocument) auth.getPrincipal());

        return ResponseEntity.ok(token);

    }
}
