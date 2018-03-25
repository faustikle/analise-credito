package br.faustikle.desafio.api.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeEncontradaException {

    public UsuarioNaoEncontradoException() {
        super("Usuario não encontrado.");
    }
}
