package br.com.handson.musicas.aplicacao.commons.validador.string;

import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import org.junit.Test;

public class QuantidadeMaximaCaracteresTest {

    @Test(expected = ParametoInvalidoException.class)
    public void deveLancarUmaExceptionAoInformarParametroNull(){

        int quantidadeCaracteres = 4;
        String parametro = null;
        Validador validador = new QuantidadeMaximaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }

    @Test(expected = ParametoInvalidoException.class)
    public void deveLancarUmaExceptionAoInformarParametroMaiorQuantidadeCaracteres(){

        int quantidadeCaracteres = 2;
        String parametro = "1111";
        Validador validador = new QuantidadeMaximaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }

    @Test
    public void naoDeveLancarUmaExeptionAoInformarParametroMenorQuantidadeCaracteres(){
        int quantidadeCaracteres = 4;

        String parametro = "111";
        Validador validador = new QuantidadeMaximaCaracteres(quantidadeCaracteres, new ValidarDefault());

        validador.validar(parametro);
    }
}
