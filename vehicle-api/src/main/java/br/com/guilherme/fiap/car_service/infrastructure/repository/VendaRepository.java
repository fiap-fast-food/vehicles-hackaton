package br.com.guilherme.fiap.car_service.infrastructure.repository;

import br.com.guilherme.fiap.car_service.infrastructure.document.venda.VendaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaRepository extends MongoRepository<VendaDocument, String> {
}
