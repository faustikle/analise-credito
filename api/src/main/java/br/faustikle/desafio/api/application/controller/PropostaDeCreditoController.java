package br.faustikle.desafio.api.application.controller;

import br.faustikle.desafio.api.application.service.AnaliseDeCreditoService;
import br.faustikle.desafio.api.application.service.ClienteService;
import br.faustikle.desafio.api.application.service.PropostaDeCreditoService;
import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.infrastructure.persistence.repository.PropostaDeCreditoRepository;
import br.faustikle.desafio.api.infrastructure.persistence.repository.UsuarioRepository;
import br.faustikle.desafio.api.presentation.PropostaDeCredito.Aprovacao;
import br.faustikle.desafio.api.presentation.PropostaDeCredito.Rejeicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/propostas")
public class PropostaDeCreditoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AnaliseDeCreditoService analiseDeCreditoService;

    @Autowired
    private PropostaDeCreditoService propostaDeCreditoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<PropostaDeCredito> listar(@RequestParam(value = "cpf", required=false) String cpf,
                                         @RequestParam(value = "status", required=false) StatusProposta status,
                                         Pageable pageable) {
        return propostaDeCreditoService.pesquisar(cpf, status, pageable);
    }

    @GetMapping("/{id}")
    public PropostaDeCredito obter(@PathVariable Long id) {
        return analiseDeCreditoService.obter(id);
    }

    @PostMapping("/solicitar/{clienteId}")
    public PropostaDeCredito solicitar(@PathVariable Long clienteId) {
        Usuario captador = usuarioRepository.findOneByEmail("captador@gmail.com").get();

        return analiseDeCreditoService.solicitar(clienteId, captador);
    }

    @PutMapping("/{id}/aprovar")
    public PropostaDeCredito aprovar(@PathVariable Long id, @RequestBody Aprovacao aprovacao) {
        Usuario analista = usuarioRepository.findOneByEmail("analista@gmail.com").get();

        return analiseDeCreditoService.aprovar(id, analista, aprovacao.getCredito());
    }

    @PutMapping("/{id}/negar")
    public PropostaDeCredito negar(@PathVariable Long id, @RequestBody Rejeicao rejeicao) {
        Usuario analista = usuarioRepository.findOneByEmail("analista@gmail.com").get();

        return analiseDeCreditoService.negar(id, analista, rejeicao.getMotivo());
    }
}
