package br.faustikle.desafio.api.application.service;

import br.faustikle.desafio.api.domain.model.cliente.Cpf;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;
import br.faustikle.desafio.api.domain.service.PropostaDeCreditoServiceInterface;
import br.faustikle.desafio.api.infrastructure.persistence.repository.PropostaDeCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PropostaDeCreditoService implements PropostaDeCreditoServiceInterface {

    @Autowired
    private PropostaDeCreditoRepository propostaDeCreditoRepository;

    @Override
    public Page<PropostaDeCredito> listar(Pageable pageable) {
        return propostaDeCreditoRepository.findAll(pageable);
    }

    @Override
    public Page<PropostaDeCredito> pesquisar(String cpf, StatusProposta statusProposta, Pageable pageable) {
        if (cpf != null && statusProposta != null) {
            return propostaDeCreditoRepository.findByStatusAndClienteDadoPessoalCpfNumero(statusProposta, cpf,
                    pageable);
        }

        if (cpf != null) {
            return propostaDeCreditoRepository.findByClienteDadoPessoalCpfNumero(cpf, pageable);
        }

        if (statusProposta != null) {
            return propostaDeCreditoRepository.findByStatus(statusProposta, pageable);
        }

        return propostaDeCreditoRepository.findAll(pageable);
    }
}
