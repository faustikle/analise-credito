package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;

public class PropostaDeCredito {

    private Long id;

    private Cliente cliente;

    private Usuario captador;

    private StatusProposta status;

    private Resultado resultado;

    public PropostaDeCredito(Cliente cliente, Usuario captador) {
        this.cliente = cliente;
        this.captador = captador;
        this.status = StatusProposta.EM_ANALISE;
    }

    public void aprovar(Usuario analista, Credito credito) {
        this.resultado = Resultado.aprovado(analista, credito);
        this.status = StatusProposta.APROVADA;
    }

    public void negar(Usuario analista, String motivo) {
        this.resultado = Resultado.negado(analista, motivo);
        this.status = StatusProposta.NEGADA;
    }
}
