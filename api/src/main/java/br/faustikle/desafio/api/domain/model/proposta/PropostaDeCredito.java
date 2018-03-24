package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PropostaDeCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_captador_id")
    private Usuario captador;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true)
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
