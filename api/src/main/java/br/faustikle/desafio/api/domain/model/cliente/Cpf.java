package br.faustikle.desafio.api.domain.model.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cpf {

    @Column(name = "cpf", length = 11)
    private String numero;

    public Cpf(String numero) {
        this.numero = numero;
    }
}
