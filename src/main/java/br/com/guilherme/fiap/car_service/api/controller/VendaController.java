package br.com.guilherme.fiap.car_service.api.controller;

import br.com.guilherme.fiap.car_service.api.response.venda.VendaResponse;
import br.com.guilherme.fiap.car_service.business.VendaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/venda")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Tag(name = "efetuar venda", description = "Efetuar venda de um veículo")
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_COMPRADOR')")
    public ResponseEntity<VendaResponse> efetuarVenda(@RequestParam String veiculoId,
                                                      @RequestParam String compradorId) {
        return ResponseEntity.ok(vendaService.efetuarVenda(veiculoId, compradorId));
    }
}
