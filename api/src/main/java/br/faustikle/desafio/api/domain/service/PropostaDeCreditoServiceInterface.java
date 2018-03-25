package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cpf;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropostaDeCreditoServiceInterface {

    public Page<PropostaDeCredito> listar(Pageable pageable);

    public Page<PropostaDeCredito> pesquisar(String cpf, StatusProposta statusProposta, Pageable pageable);
}
