package br.faustikle.desafio.api.domain.model.cliente;

public enum Genero {
    MASCULINO("MASCULINO"), FEMININO("FEMININO");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
