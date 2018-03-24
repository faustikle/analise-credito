package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cpf;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.proposta.StatusProposta;

import java.util.List;

public interface PropostaDeCreditoServiceInterface {

    public List<PropostaDeCredito> pesquisar(Cpf cpf, StatusProposta statusProposta);

    public List<PropostaDeCredito> pesquisar(Cpf cpf);

    public List<PropostaDeCredito> pesquisar(StatusProposta statusProposta);
}
