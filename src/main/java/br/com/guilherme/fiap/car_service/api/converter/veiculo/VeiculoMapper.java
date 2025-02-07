package br.com.guilherme.fiap.car_service.api.converter.veiculo;

import br.com.guilherme.fiap.car_service.api.request.veiculo.VeiculoRequest;
import br.com.guilherme.fiap.car_service.api.response.veiculo.VeiculoResponse;
import br.com.guilherme.fiap.car_service.infrastructure.document.veiculo.VeiculoDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoResponse toVeiculoResponse(VeiculoDocument veiculoDocument);


    VeiculoDocument toVeiculoDocument(VeiculoRequest veiculoRequest);
}
