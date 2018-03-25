package br.faustikle.desafio.api.application.service;

import br.faustikle.desafio.api.domain.exception.UsuarioNaoEncontradoException;
import br.faustikle.desafio.api.domain.model.usuario.Usuario;
import br.faustikle.desafio.api.domain.service.UsuarioServiceInterface;
import br.faustikle.desafio.api.infrastructure.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obterPeloEmail(String email) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuario = usuarioRepository.findOneByEmail(email);

        if (!usuario.isPresent()) {
            throw new UsuarioNaoEncontradoException();
        }

        return usuario.get();
    }
}
