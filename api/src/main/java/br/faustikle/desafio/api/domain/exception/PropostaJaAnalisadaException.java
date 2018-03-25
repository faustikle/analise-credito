package br.faustikle.desafio.api.domain.exception;

public class PropostaJaAnalisadaException extends RuntimeException {
    public PropostaJaAnalisadaException() {
        super("Esta proposta já foi analisada.");
    }
}
