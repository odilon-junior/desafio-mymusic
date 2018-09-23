package br.com.handson.musicas.aplicacao;

import br.com.handson.musicas.aplicacao.ws.v1.response.error.Erro;
import br.com.handson.musicas.aplicacao.exceptions.CodigoErro;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

public class BundleMessagesTest {

    private MessageSource messageSource;
    private BundleMessages bundleMessages;

    @Before
    public void init() {
        messageSource = createMock(MessageSource.class);
        bundleMessages = new BundleMessages(messageSource);
    }

    @Test
    public void quandoCriarErroComChaveValidaEntaoInstanciaDeveSerRetornadaComCodigoEMensagem() {

        CodigoErro codigoErro = CodigoErro.ERRO_INTERNO;
        String[] detalhes = { "nome" };
        String mensagem = "Preencha o campo!";

        expect(messageSource.getMessage(codigoErro.getCodigo(), detalhes, Locale.getDefault()))
                .andReturn(mensagem);
        replay(messageSource);

        Erro erro = bundleMessages.criarErro(codigoErro, detalhes);

        assertEquals(codigoErro.getCodigo(), erro.getCodigo());
        assertEquals(mensagem, erro.getMensagem());
    }

    @Test
    public void quandoCriarErroComChaveInvalidaEntaoInstanciaDeveSerRetornadaComCodigoEMensagemPadrao() {

        CodigoErro codigoErro = CodigoErro.ERRO_INTERNO;
        String[] detalhes = { "nome" };

        expect(messageSource.getMessage(codigoErro.getCodigo(), detalhes, Locale.getDefault()))
                .andThrow(new NoSuchMessageException("CODIGO_INEXISTENTE"));
        replay(messageSource);

        Erro erro = bundleMessages.criarErro(codigoErro, detalhes);

        assertEquals(codigoErro.getCodigo(), erro.getCodigo());
        assertEquals(BundleMessages.MENSAGEM_ERRO_PADRAO + codigoErro.getCodigo(), erro.getMensagem());
    }
}
