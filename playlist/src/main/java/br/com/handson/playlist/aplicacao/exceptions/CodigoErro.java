package br.com.handson.playlist.aplicacao.exceptions;

public enum CodigoErro {

    /* Generic domain exceptions */
    ERRO_INTERNO("000"),
    USUARIO_NAO_ENCONTRADO("001");

    private final String codigo;

    CodigoErro(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
