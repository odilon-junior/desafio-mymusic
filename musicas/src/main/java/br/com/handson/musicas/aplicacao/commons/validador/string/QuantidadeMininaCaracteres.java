package br.com.handson.musicas.aplicacao.commons.validador.string;

import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import br.com.handson.musicas.aplicacao.exceptions.CodigoErro;

public class QuantidadeMininaCaracteres implements Validador {

    private int quantidadeCaractes;
    private Validador validador;

    public QuantidadeMininaCaracteres(int quantidadeCaracteres, Validador validador) {
        this.validador = validador;
        this.quantidadeCaractes = quantidadeCaracteres;
    }

    @Override
    public void validar(String valor) {
        if(valor == null || valor.length() < quantidadeCaractes){
            throw new ParametoInvalidoException(CodigoErro.PARAMETRO_NOME_INVALIDO, "Quantidade de caracters informado " +
                    "e invalido");
        }
        validador.validar(valor);
    }
}
