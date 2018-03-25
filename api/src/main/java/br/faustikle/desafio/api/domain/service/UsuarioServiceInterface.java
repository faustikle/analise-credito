package br.faustikle.desafio.api.domain.service;

import br.faustikle.desafio.api.domain.model.usuario.Usuario;

public interface UsuarioServiceInterface {

    public Usuario obterPeloEmail(String email);
}
