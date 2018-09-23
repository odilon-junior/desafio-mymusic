package br.com.handson.musicas.aplicacao.exceptions;

public enum CodigoErro {

    /* Generic domain exceptions */
    ERRO_INTERNO("000"),
    PARAMETRO_NOME_INVALIDO("001");

    private final String codigo;

    CodigoErro(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
