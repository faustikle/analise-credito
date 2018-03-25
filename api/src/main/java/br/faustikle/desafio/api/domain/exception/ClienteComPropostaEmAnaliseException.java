package br.faustikle.desafio.api.domain.exception;

public class ClienteComPropostaEmAnaliseException extends RuntimeException {
    public ClienteComPropostaEmAnaliseException() {
        super("Este cliente possui uma solicitação em análise.");
    }
}
