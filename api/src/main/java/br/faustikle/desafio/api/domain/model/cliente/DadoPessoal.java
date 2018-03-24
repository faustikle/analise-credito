package br.faustikle.desafio.api.domain.model.cliente;

public class DadoPessoal {

    private String nome;

    private Cpf cpf;

    private Endereco endereco;

    private String telefone;

    public DadoPessoal(String nome, Cpf cpf, Endereco endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
