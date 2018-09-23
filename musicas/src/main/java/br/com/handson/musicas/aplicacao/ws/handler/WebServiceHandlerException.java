package br.com.handson.musicas.aplicacao.ws.handler;

import br.com.handson.musicas.aplicacao.BundleMessages;
import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import br.com.handson.musicas.aplicacao.exceptions.CodigoErro;
import br.com.handson.musicas.aplicacao.ws.v1.response.error.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebServiceHandlerException {

    private final BundleMessages bundleMessages;
//    private Logger log = LoggerFactory.getLogger(WebServiceHandlerExceptions.class);

    @Autowired
    public WebServiceHandlerException(BundleMessages bundleMessages) {
        this.bundleMessages = bundleMessages;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Erro> handlerErroNaoMapeado(Throwable e) {

//        log.error(e.getMessage(), e);

        Erro erro = bundleMessages.criarErro(CodigoErro.ERRO_INTERNO);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @ExceptionHandler(ParametoInvalidoException.class)
    public ResponseEntity<Erro> handlerParametroInvalido(ParametoInvalidoException e) {

//        log.error("Parametro invalido recebido", e);

        Erro errorCode = bundleMessages.criarErro(e.getCodigoErro(), e.getDetalhes());
        return ResponseEntity.badRequest().body(errorCode);
    }
}
