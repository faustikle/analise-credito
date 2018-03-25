package br.faustikle.desafio.api.application.controller;

import br.faustikle.desafio.api.infrastructure.service.AutenticacaoService;
import br.faustikle.desafio.api.presentation.autenticacao.Login;
import br.faustikle.desafio.api.presentation.autenticacao.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/token")
    public ResponseEntity<Token> token(@RequestBody Login login) {
        Token token = autenticacaoService.autenticar(login);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
