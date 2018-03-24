package br.faustikle.desafio.api.domain.model.proposta;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;

public class Resultado {

    private Usuario analisador;

    private String motivo;

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
