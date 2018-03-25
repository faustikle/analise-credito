package br.faustikle.desafio.api.application.exception;

import br.faustikle.desafio.api.domain.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ClienteNaoEncontradoException.class })
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeEncontradaException exception,
                                                                         WebRequest request) {
        return handleExceptionInternal(exception, obterMensagemDeErro(exception.getMessage()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ AlteracaoNaoPermitidaException.class })
    public ResponseEntity<Object> handleAlteracaoNaoPermitidaException(AlteracaoNaoPermitidaException exception,
                                                                       WebRequest request) {
        return handleExceptionInternal(exception, obterMensagemDeErro(exception.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ PropostaJaAnalisadaException.class })
    public ResponseEntity<Object> handlePropostaJaAnalisadaException(PropostaJaAnalisadaException exception,
                                                                       WebRequest request) {
        return handleExceptionInternal(exception, obterMensagemDeErro(exception.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ ClienteComPropostaEmAnaliseException.class })
    public ResponseEntity<Object> handleClienteComPropostaEmAnaliseException(
            ClienteComPropostaEmAnaliseException exception, WebRequest request) {
        return handleExceptionInternal(exception, obterMensagemDeErro(exception.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException exception,
                                                                       WebRequest request) {
        return handleExceptionInternal(exception, obterMensagemDeErro("Usuario ou senha inválida."),
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    private HashMap<String, String> obterMensagemDeErro(String mensagem) {
        HashMap<String, String> mensagemDeErro = new HashMap<>();
        mensagemDeErro.put("erro", mensagem);

        return mensagemDeErro;
    }
}
