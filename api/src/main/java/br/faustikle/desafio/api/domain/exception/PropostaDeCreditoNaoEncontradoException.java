package br.faustikle.desafio.api.domain.exception;

public class PropostaDeCreditoNaoEncontradoException extends EntidadeEncontradaException {

    public PropostaDeCreditoNaoEncontradoException() {
        super("Proposta não encontrada.");
    }
}
