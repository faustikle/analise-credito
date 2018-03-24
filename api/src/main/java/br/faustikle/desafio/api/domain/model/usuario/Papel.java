package br.faustikle.desafio.api.domain.model.usuario;

public enum Papel {
    ANALISTA_DE_CREDITO("ANALISTA_DE_CREDITO"),
    CAPTADOR_DE_PROPOSTA("CAPTADOR_DE_PROPOSTA");

    private String descricao;

    Papel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
