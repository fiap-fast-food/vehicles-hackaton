package br.com.guilherme.fiap.car_service.api.converter.usuario;

import br.com.guilherme.fiap.car_service.api.request.usuario.UsuarioRequest;
import br.com.guilherme.fiap.car_service.api.request.veiculo.VeiculoRequest;
import br.com.guilherme.fiap.car_service.api.response.usuario.UsuarioResponse;
import br.com.guilherme.fiap.car_service.api.response.veiculo.VeiculoResponse;
import br.com.guilherme.fiap.car_service.infrastructure.document.usuario.UsuarioDocument;
import br.com.guilherme.fiap.car_service.infrastructure.document.veiculo.VeiculoDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponse toUsuarioResponse(UsuarioDocument usuarioDocument);


    UsuarioDocument toUsuarioDocument(UsuarioRequest usuarioRequest);
}
