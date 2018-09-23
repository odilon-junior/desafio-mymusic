package br.com.handson.musicas.aplicacao.commons.validador.string;

import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import br.com.handson.musicas.aplicacao.exceptions.CodigoErro;

public class QuantidadeMaximaCaracteres  implements Validador {

    private int quantidadeMaximaCaractere;
    private Validador validador;

    public QuantidadeMaximaCaracteres(int quantidadeMaximaCaractere, Validador validador) {
        this.validador = validador;
        this.quantidadeMaximaCaractere = quantidadeMaximaCaractere;
    }

    @Override
    public void validar(String valor) {
        if(valor == null || valor.length() > quantidadeMaximaCaractere){
            throw new ParametoInvalidoException(CodigoErro.PARAMETRO_NOME_INVALIDO, "Quantidade de caracters informado " +
                    "e invalido");
        }
        validador.validar(valor);
    }
}
