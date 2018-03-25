package br.faustikle.desafio.api.domain.model.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Cpf {

    @NotNull
    @Column(name = "cpf", length = 11)
    private String numero;

    private Cpf() {
    }

    public String getNumero() {
        return numero;
    }

    public Cpf(String numero) {
        this.numero = numero;
    }

    public boolean equals(Cpf cpf) {
        return cpf.getNumero().equals(numero);
    }
}
