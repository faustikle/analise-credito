package br.faustikle.desafio.api.presentation.autenticacao;

import java.util.Date;

public class Token {

    private String token;

    private Date expiraEm;

    public Token(String token, Date expiraEm) {
        this.token = token;
        this.expiraEm = expiraEm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiraEm() {
        return expiraEm;
    }

    public void setExpiraEm(Date expiraEm) {
        this.expiraEm = expiraEm;
    }
}
