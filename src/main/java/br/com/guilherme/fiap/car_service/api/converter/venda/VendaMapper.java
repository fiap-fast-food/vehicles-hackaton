package br.com.guilherme.fiap.car_service.api.converter.venda;

import br.com.guilherme.fiap.car_service.api.request.venda.VendaRequest;
import br.com.guilherme.fiap.car_service.api.response.venda.VendaResponse;
import br.com.guilherme.fiap.car_service.infrastructure.document.venda.VendaDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    VendaResponse toVendaResponse(VendaDocument vendaDocument);

    VendaDocument toVendaDocument(VendaRequest vendaRequest);
}
