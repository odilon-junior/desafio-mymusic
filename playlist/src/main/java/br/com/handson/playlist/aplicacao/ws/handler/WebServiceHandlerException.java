package br.com.handson.playlist.aplicacao.ws.handler;

import br.com.handson.playlist.aplicacao.BundleMessages;
import br.com.handson.playlist.aplicacao.exceptions.CodigoErro;
import br.com.handson.playlist.aplicacao.ws.v1.response.error.Erro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebServiceHandlerException {

    private final BundleMessages bundleMessages;
    private Logger log = LoggerFactory.getLogger(WebServiceHandlerException.class);

    @Autowired
    public WebServiceHandlerException(BundleMessages bundleMessages) {
        this.bundleMessages = bundleMessages;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Erro> handlerErroNaoMapeado(Throwable e) {

        log.error(e.getMessage(), e);

        Erro erro = bundleMessages.criarErro(CodigoErro.ERRO_INTERNO);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

}
