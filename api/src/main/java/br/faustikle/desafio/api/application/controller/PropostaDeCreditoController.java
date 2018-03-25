package br.faustikle.desafio.api.application.controller;

import br.faustikle.desafio.api.application.service.AnaliseDeCreditoService;
import br.faustikle.desafio.api.application.service.ClienteService;
import br.faustikle.desafio.api.application.service.PropostaDeCreditoService;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;
import br.faustikle.desafio.api.infrastructure.service.AutenticacaoService;
import br.faustikle.desafio.api.presentation.PropostaDeCredito.Aprovacao;
import br.faustikle.desafio.api.presentation.PropostaDeCredito.Rejeicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    private AutenticacaoService autenticacaoService;

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
    @PreAuthorize("hasAuthority('CAPTADOR_DE_PROPOSTA')")
    public PropostaDeCredito solicitar(@PathVariable Long clienteId) {
        return analiseDeCreditoService.solicitar(clienteId, autenticacaoService.obterUsuarioLogado());
    }

    @PutMapping("/{id}/aprovar")
    @PreAuthorize("hasAuthority('ANALISTA_DE_CREDITO')")
    public PropostaDeCredito aprovar(@PathVariable Long id, @RequestBody Aprovacao aprovacao) {
        return analiseDeCreditoService.aprovar(id, autenticacaoService.obterUsuarioLogado(), aprovacao.getCredito());
    }

    @PutMapping("/{id}/negar")
    @PreAuthorize("hasAuthority('ANALISTA_DE_CREDITO')")
    public PropostaDeCredito negar(@PathVariable Long id, @RequestBody Rejeicao rejeicao) {
        return analiseDeCreditoService.negar(id, autenticacaoService.obterUsuarioLogado(), rejeicao.getMotivo());
    }
}
