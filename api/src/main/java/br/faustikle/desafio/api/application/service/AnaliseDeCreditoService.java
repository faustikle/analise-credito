package br.faustikle.desafio.api.application.service;

import br.faustikle.desafio.api.domain.exception.ClienteComPropostaEmAnaliseException;
import br.faustikle.desafio.api.domain.exception.PropostaDeCreditoNaoEncontradoException;
import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.proposta.Credito;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.domain.service.AnaliseDeCreditoServiceInterface;
import br.faustikle.desafio.api.infrastructure.persistence.repository.PropostaDeCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AnaliseDeCreditoService implements AnaliseDeCreditoServiceInterface {

    @Autowired
    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Autowired
    private ClienteService clienteService;

    @Override
    public PropostaDeCredito obter(Long id) {
        Optional<PropostaDeCredito> proposta = propostaDeCreditoRepository.findById(id);

        if (!proposta.isPresent()) {
            throw new PropostaDeCreditoNaoEncontradoException();
        }

        return proposta.get();
    }

    @Override
    public PropostaDeCredito solicitar(Long clienteId, Usuario captador) {
        Cliente cliente = clienteService.obter(clienteId);

        if (cliente.possuiPropostasEmAnalise()) {
            throw new ClienteComPropostaEmAnaliseException();
        }

        PropostaDeCredito proposta = new PropostaDeCredito(cliente, captador);

        return propostaDeCreditoRepository.save(proposta);
    }

    @Override
    public PropostaDeCredito aprovar(Long propostaId, Usuario analista, BigDecimal credito) {
        PropostaDeCredito proposta = obter(propostaId);
        proposta.aprovar(analista, new Credito(credito));

        return propostaDeCreditoRepository.save(proposta);
    }

    @Override
    public PropostaDeCredito negar(Long propostaId, Usuario analista, String motivo) {
        PropostaDeCredito proposta = obter(propostaId);
        proposta.negar(analista, motivo);

        return propostaDeCreditoRepository.save(proposta);
    }
}
