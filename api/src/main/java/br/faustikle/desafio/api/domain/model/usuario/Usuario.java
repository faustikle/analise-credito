package br.faustikle.desafio.api.domain.model.usuario;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 8, max = 32)
    @Column(name = "senha", nullable = false)
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "papel")
    private Papel papel;

    private Usuario(String email, String senha, Papel papel) {
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public static Usuario newAnalista(String email, String senha) {
        return new Usuario(email, senha, Papel.ANALISTA_DE_CREDITO);
    }

    public static Usuario newCaptador(String email, String senha) {
        return new Usuario(email, senha, Papel.CAPTADOR_DE_PROPOSTA);
    }
}
