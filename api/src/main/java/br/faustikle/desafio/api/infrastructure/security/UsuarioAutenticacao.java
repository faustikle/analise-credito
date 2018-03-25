package br.faustikle.desafio.api.infrastructure.security;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UsuarioAutenticacao extends User {

    private Usuario usuario;

    public UsuarioAutenticacao(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
