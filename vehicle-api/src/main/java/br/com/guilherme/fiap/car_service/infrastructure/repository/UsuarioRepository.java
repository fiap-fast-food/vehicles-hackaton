package br.com.guilherme.fiap.car_service.infrastructure.repository;

import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.UsuarioDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String> {

    UserDetails findByLogin(String login);
}
