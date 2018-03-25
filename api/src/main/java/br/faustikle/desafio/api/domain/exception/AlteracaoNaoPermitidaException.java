package br.faustikle.desafio.api.domain.exception;

public class AlteracaoNaoPermitidaException extends RuntimeException {
    public AlteracaoNaoPermitidaException(String message) {
        super(message);
    }
}
