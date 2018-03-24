package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Resultado {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_analisador_id")
    private Usuario analisador;

    private String motivo;

    @Embedded
    private Credito credito;

    private Resultado(Usuario analisador, Credito credito) {
        this.analisador = analisador;
        this.credito = credito;
    }

    private Resultado(Usuario analisador, String motivo) {
        this.analisador = analisador;
        this.motivo = motivo;
    }

    public static Resultado aprovado(Usuario analista, Credito credito) {
        return new Resultado(analista, credito);
    }

    public static Resultado negado(Usuario analista, String motivo) {
        return new Resultado(analista, motivo);
    }
}
