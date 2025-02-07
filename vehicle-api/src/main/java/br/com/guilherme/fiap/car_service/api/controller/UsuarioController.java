package br.com.guilherme.fiap.car_service.api.controller;

import br.com.guilherme.fiap.car_service.api.request.usuario.UsuarioRequest;
import br.com.guilherme.fiap.car_service.business.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Tag(name = "comprador", description = "responsável por cadastrar um comprador")
    @PostMapping("/comprador")
    public ResponseEntity cadastrarComprador(@RequestBody UsuarioRequest request) throws BadRequestException {
        service.cadastrarComprador(request);
        return ResponseEntity.ok().build();
    }

    @Tag(name = "usuário", description = "responsável por cadastrar um usuário")
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody UsuarioRequest request) throws BadRequestException {
        service.cadastrarUsuario(request);
        return ResponseEntity.ok().build();
    }
}
