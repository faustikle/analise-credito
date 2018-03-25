package br.faustikle.desafio.api.infrastructure.service;

import br.faustikle.desafio.api.application.service.UsuarioService;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.infrastructure.security.UsuarioAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obterPeloEmail(s);

        Set<SimpleGrantedAuthority> permissoes = new HashSet<>();
        permissoes.add(new SimpleGrantedAuthority(usuario.getPapel().getDescricao()));

        return new UsuarioAutenticacao(usuario, permissoes);
    }
}
