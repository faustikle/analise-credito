package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.exception.PropostaJaAnalisadaException;
import br.faustikle.desafio.api.domain.model.cliente.Cliente;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "propostas_de_credito")
public class PropostaDeCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_captador_id")
    private Usuario captador;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusProposta status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = true)
    private Resultado resultado;

    @NotNull
    private LocalDateTime data;

    private PropostaDeCredito() {
    }

    public PropostaDeCredito(Cliente cliente, Usuario captador) {
        this.cliente = cliente;
        this.captador = captador;
        this.status = StatusProposta.EM_ANALISE;
        this.data = LocalDateTime.now();
    }

    public void aprovar(Usuario analista, Credito credito) {
        verificarSePropostaJaFoiAnalisada();

        this.resultado = Resultado.aprovado(analista, credito);
        this.status = StatusProposta.APROVADA;
    }

    public void negar(Usuario analista, String motivo) {
        verificarSePropostaJaFoiAnalisada();

        this.resultado = Resultado.negado(analista, motivo);
        this.status = StatusProposta.NEGADA;
    }

    public boolean estaEmAnalise() {
        return status == StatusProposta.EM_ANALISE;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getCaptador() {
        return captador;
    }

    public StatusProposta getStatus() {
        return status;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public Long getId() {
        return id;
    }

    private void verificarSePropostaJaFoiAnalisada() throws PropostaJaAnalisadaException {
        if (resultado != null) {
            throw new PropostaJaAnalisadaException();
        }
    }
}
