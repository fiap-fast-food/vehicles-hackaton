package br.com.guilherme.fiap.car_service.business;

import br.com.guilherme.fiap.car_service.api.converter.veiculo.VeiculoMapper;
import br.com.guilherme.fiap.car_service.api.request.veiculo.VeiculoRequest;
import br.com.guilherme.fiap.car_service.api.response.veiculo.VeiculoResponse;
import br.com.guilherme.fiap.car_service.infrastructure.document.veiculo.VeiculoDocument;
import br.com.guilherme.fiap.car_service.infrastructure.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;
    private final VeiculoMapper mapper;

    public VeiculoService(VeiculoRepository repository, VeiculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public VeiculoResponse cadastrar(VeiculoRequest veiculoRequest) {
        VeiculoDocument veiculoDocument = mapper.toVeiculoDocument(veiculoRequest);
        VeiculoDocument save = repository.save(veiculoDocument);

        return mapper.toVeiculoResponse(save);
    }

    public VeiculoResponse editarVeiculo(String id, VeiculoRequest veiculoRequest) {
        VeiculoDocument veiculoDocument = mapper.toVeiculoDocument(veiculoRequest);
        veiculoDocument.setId(id);
        VeiculoDocument veiculoUpdated = repository.save(veiculoDocument);
        return mapper.toVeiculoResponse(veiculoUpdated);
    }

    public List<VeiculoResponse> listarVeiculosDisponiveis() {
        List<VeiculoDocument> veiculos = repository.findByVendidoFalseOrderByPrecoAsc();

        return veiculos.stream()
                .map(mapper::toVeiculoResponse)
                .toList();

    }

    public List<VeiculoResponse> listarVeiculosVendidos() {
        List<VeiculoDocument> veiculos = repository.findByVendidoTrueOrderByPrecoAsc();

        return veiculos.stream()
                .map(mapper::toVeiculoResponse)
                .toList();

    }
}
