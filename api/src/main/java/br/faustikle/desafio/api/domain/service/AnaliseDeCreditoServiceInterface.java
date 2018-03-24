package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.proposta.Credito;
import br.faustikle.desafio.api.domain.model.proposta.PropostaDeCredito;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;

public interface AnaliseDeCreditoServiceInterface {

    public PropostaDeCredito solicitar(Cliente cliente, Usuario captador);

    public PropostaDeCredito aprovar(PropostaDeCredito proposta, Usuario analista, Credito credito);

    public PropostaDeCredito negar(PropostaDeCredito proposta, Usuario analista, String motivo);
}
