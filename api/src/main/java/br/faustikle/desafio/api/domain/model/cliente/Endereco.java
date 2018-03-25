package br.faustikle.desafio.api.domain.model.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {

    @NotNull
    private String logradouro;

    @NotNull
    private String numero;

    @NotNull
    @Column(length = 8)
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    private Endereco() {
    }

    public Endereco(String logradouro, String numero, String cep, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
