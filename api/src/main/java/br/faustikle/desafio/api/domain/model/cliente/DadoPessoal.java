package br.faustikle.desafio.api.domain.model.cliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Embeddable
public class DadoPessoal {

    @NotNull
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Embedded
    private Cpf cpf;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(length = 11)
    private String telefone;

    @NotNull
    private LocalDate dataDeNascimento;

    private DadoPessoal() {
    }

    public DadoPessoal(String nome, Genero genero, Cpf cpf, Endereco endereco,
                       String telefone, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
}
