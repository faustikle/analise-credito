package br.faustikle.desafio.api.domain.model.usuario;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 8, max = 64)
    @Column(nullable = false)
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Papel papel;

    public Usuario() {
    }

    private Usuario(String nome, String email, String senha, Papel papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public static Usuario newAnalista(String nome, String email, String senha) {
        return new Usuario(nome, email, senha, Papel.ANALISTA_DE_CREDITO);
    }

    public static Usuario newCaptador(String nome, String email, String senha) {
        return new Usuario(nome, email, senha, Papel.CAPTADOR_DE_PROPOSTA);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Papel getPapel() {
        return papel;
    }
}
