package br.com.guilherme.fiap.car_service.business;

import br.com.guilherme.fiap.car_service.api.converter.usuario.UsuarioMapper;
import br.com.guilherme.fiap.car_service.api.request.usuario.UsuarioRequest;
import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.PerfilEnum;
import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.UsuarioDocument;
import br.com.guilherme.fiap.car_service.infrastructure.repository.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void cadastrarComprador(UsuarioRequest usuarioRequest) throws BadRequestException {
        validarUsuario(usuarioRequest);
        UsuarioDocument usuarioDocument = mapper.toUsuarioDocument(usuarioRequest);


        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDocument.getPassword());

        usuarioDocument.setSenha(encryptedPassword);
        usuarioDocument.setPerfil(PerfilEnum.COMPRADOR);
        repository.save(usuarioDocument);
    }


    public void cadastrarUsuario(UsuarioRequest usuarioRequest) throws BadRequestException {
        validarUsuario(usuarioRequest);
        UsuarioDocument usuarioDocument = mapper.toUsuarioDocument(usuarioRequest);

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioDocument.getPassword());
        usuarioDocument.setSenha(encryptedPassword);

        usuarioDocument.setPerfil(PerfilEnum.ADMIN);
        repository.save(usuarioDocument);
    }

    private void validarUsuario(UsuarioRequest usuarioRequest) throws BadRequestException {
        if(this.repository.findByLogin(usuarioRequest.getLogin()) != null) {
            throw new BadRequestException("Login já cadastrado");
        }
    }
}
