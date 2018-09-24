package br.com.handson.playlist.aplicacao;

import br.com.handson.playlist.aplicacao.exceptions.CodigoErro;
import br.com.handson.playlist.aplicacao.ws.v1.response.error.Erro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessages {

    private Logger log = LoggerFactory.getLogger(BundleMessages.class);
    protected static final String MENSAGEM_ERRO_PADRAO = "Erro inesperado: ";

    private final MessageSource messageSource;

    public BundleMessages(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Erro criarErro(CodigoErro codigoErro, String... parametros) {

        String codigo = codigoErro.getCodigo();
        String mensagem = this.getMessage(codigo, parametros);

        return new Erro(mensagem, codigo);
    }

    public String getMessage(final String key, final String... args) {

        try {
            return messageSource.getMessage(key, args, Locale.getDefault());
        } catch (NoSuchMessageException ex) {
            log.error(ex.getMessage(), ex);
        }

        return MENSAGEM_ERRO_PADRAO + key;
    }
}