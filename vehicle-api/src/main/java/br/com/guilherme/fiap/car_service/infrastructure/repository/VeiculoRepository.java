package br.com.guilherme.fiap.car_service.infrastructure.repository;

import br.com.guilherme.fiap.car_service.infrastructure.document.veiculo.VeiculoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VeiculoRepository extends MongoRepository<VeiculoDocument, String> {
    List<VeiculoDocument> findByVendidoFalseOrderByPrecoAsc();
    List<VeiculoDocument> findByVendidoTrueOrderByPrecoAsc();
}

