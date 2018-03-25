package br.faustikle.desafio.api.infrastructure.service;

import br.faustikle.desafio.api.application.service.UsuarioService;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.infrastructure.security.UsuarioAutenticacao;
import br.faustikle.desafio.api.presentation.autenticacao.Login;
import br.faustikle.desafio.api.presentation.autenticacao.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService JWTService;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    public Token autenticar(Login login) {
        String email = login.getEmail();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getSenha());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JWTService.gerarToken(usuarioService.obterPeloEmail(email));
        Date expiracao = JWTService.obterExpiracao(token);
        return new Token(token, expiracao);
    }

    public Usuario obterUsuarioLogado() {
        UsuarioAutenticacao usuarioAutenticado = (UsuarioAutenticacao) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        return usuarioService.obterPeloEmail(usuarioAutenticado.getUsuario().getEmail());
    }
}
