package br.com.handson.musicas.aplicacao.commons.validador.string;

import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import org.junit.Test;

public class QuantidadeMinimaCaracteresTest {

    @Test(expected = ParametoInvalidoException.class)
    public void deveLancarUmaExceptionAoInformarParametroNull(){

        int quantidadeCaracteres = 4;
        String parametro = null;
        Validador validador = new QuantidadeMininaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }

    @Test(expected = ParametoInvalidoException.class)
    public void deveLancarUmaExceptionAoInformarParametroMenorQueQuantidadeCaracteres(){

        int quantidadeCaracteres = 3;
        String parametro = "11";
        Validador validador = new QuantidadeMininaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }

    @Test
    public void naoDeveLancarUmaExeptionAoInformarParametroMaiorQueQuantidadeCaracteres(){
        int quantidadeCaracteres = 4;

        String parametro = "11111";
        Validador validador = new QuantidadeMininaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }
}
