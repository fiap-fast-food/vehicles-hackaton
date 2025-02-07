package br.com.guilherme.fiap.car_service.api.controller;

import br.com.guilherme.fiap.car_service.api.request.veiculo.VeiculoRequest;
import br.com.guilherme.fiap.car_service.api.response.veiculo.VeiculoResponse;
import br.com.guilherme.fiap.car_service.business.VeiculoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/veiculo")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @Tag(name = "cadastrar veículo", description = "Cadastra um veículo")
    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastrar(@RequestBody VeiculoRequest request) {
        return ResponseEntity.ok(service.cadastrar(request));
    }

    @Tag(name = "editar veículo", description = "Edita os dados de um veículo existente")
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> editarVeiculo(@PathVariable("id") String id,
                                                         @RequestBody VeiculoRequest request) {
        return ResponseEntity.ok(service.editarVeiculo(id, request));
    }

    @Tag(name = "listar veículos disponíveis", description = "Lista veículos disponíveis")
    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponse>> listarVeiculosDisponiveis() {
        return ResponseEntity.ok(service.listarVeiculosDisponiveis());
    }

    @Tag(name = "listar veículos vendidos", description = "Lista veículos vendidos")
    @GetMapping("/vendidos")
    public ResponseEntity<List<VeiculoResponse>> listarVeiculosVendidos() {
        return ResponseEntity.ok(service.listarVeiculosVendidos());
    }
}
