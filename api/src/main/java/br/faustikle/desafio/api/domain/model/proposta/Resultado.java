package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_analisador_id")
    private Usuario analisador;

    @Column(nullable = true)
    private String motivo;

    @Embedded
    private Credito credito;

    @NotNull
    private LocalDateTime data;

    private Resultado() {
    }

    private Resultado(Usuario analisador, Credito credito) {
        this.analisador = analisador;
        this.credito = credito;
        this.data = LocalDateTime.now();
    }

    private Resultado(Usuario analisador, String motivo) {
        this.analisador = analisador;
        this.motivo = motivo;
        this.data = LocalDateTime.now();
    }

    public static Resultado aprovado(Usuario analista, Credito credito) {
        return new Resultado(analista, credito);
    }

    public static Resultado negado(Usuario analista, String motivo) {
        return new Resultado(analista, motivo);
    }

    public Usuario getAnalisador() {
        return analisador;
    }

    public String getMotivo() {
        return motivo;
    }

    public Credito getCredito() {
        return credito;
    }
}
