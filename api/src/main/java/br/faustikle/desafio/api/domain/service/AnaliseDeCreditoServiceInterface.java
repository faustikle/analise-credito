package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.proposta.Credito;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;

import java.math.BigDecimal;

public interface AnaliseDeCreditoServiceInterface {

    public PropostaDeCredito obter(Long id);

    public PropostaDeCredito solicitar(Long clienteId, Usuario captador);

    public PropostaDeCredito aprovar(Long propostaId, Usuario analista, BigDecimal credito);

    public PropostaDeCredito negar(Long propostaId, Usuario analista, String motivo);
}
