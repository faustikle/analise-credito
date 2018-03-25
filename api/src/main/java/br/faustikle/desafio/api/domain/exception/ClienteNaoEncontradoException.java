package br.faustikle.desafio.api.domain.exception;

public class ClienteNaoEncontradoException extends EntidadeEncontradaException {

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado.");
    }
}
