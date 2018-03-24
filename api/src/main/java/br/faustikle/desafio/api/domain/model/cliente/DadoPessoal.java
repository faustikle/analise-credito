package br.faustikle.desafio.api.domain.model.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class DadoPessoal {

    private String nome;

    @Embedded
    private Cpf cpf;

    @Embedded
    private Endereco endereco;

    @Column(length = 11)
    private String telefone;

    public DadoPessoal(String nome, Cpf cpf, Endereco endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
