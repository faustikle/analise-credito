package br.faustikle.desafio.api.domain.model.usuario;

public class Usuario {

    private Long id;

    private String email;

    private String senha;

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
