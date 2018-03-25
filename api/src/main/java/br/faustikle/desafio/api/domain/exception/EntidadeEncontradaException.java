package br.faustikle.desafio.api.domain.exception;

public abstract class EntidadeEncontradaException extends RuntimeException {

    public EntidadeEncontradaException(String message) {
        super(message);
    }
}
