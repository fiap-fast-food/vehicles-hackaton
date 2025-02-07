package br.com.guilherme.fiap.car_service.business;

import br.com.guilherme.fiap.car_service.api.converter.venda.VendaMapper;
import br.com.guilherme.fiap.car_service.api.response.venda.VendaResponse;
import br.com.guilherme.fiap.car_service.infrastructure.document.veiculo.VeiculoDocument;
import br.com.guilherme.fiap.car_service.infrastructure.document.venda.VendaDocument;
import br.com.guilherme.fiap.car_service.infrastructure.exceptions.BusinessException;
import br.com.guilherme.fiap.car_service.infrastructure.repository.UsuarioRepository;
import br.com.guilherme.fiap.car_service.infrastructure.repository.VeiculoRepository;
import br.com.guilherme.fiap.car_service.infrastructure.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final VendaMapper vendaMapper;

    public VendaService(VendaRepository vendaRepository,
                        UsuarioRepository usuarioRepository,
                        VeiculoRepository veiculoRepository,
                        VendaMapper vendaMapper) {
        this.vendaRepository = vendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.veiculoRepository = veiculoRepository;
        this.vendaMapper = vendaMapper;
    }

    public VendaResponse efetuarVenda(String veiculoId, String compradorId) {
        VeiculoDocument veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() ->
                new BusinessException("Veiculo não encontrado pelo id: ".concat(veiculoId)));

        usuarioRepository.findById(compradorId).orElseThrow(() ->
                new BusinessException("Comprador não encontrado pelo id: ".concat(compradorId)));

        veiculo.setVendido(Boolean.TRUE);
        veiculoRepository.save(veiculo);

        VendaDocument vendaDocument = new VendaDocument();
        vendaDocument.setDataVenda(LocalDateTime.now());
        vendaDocument.setVeiculoId(veiculoId);
        vendaDocument.setCompradorId(compradorId);
        vendaDocument.setValorVenda(veiculo.getPreco());

        VendaDocument vendaSaved = vendaRepository.save(vendaDocument);

        return vendaMapper.toVendaResponse(vendaSaved);
    }
}
