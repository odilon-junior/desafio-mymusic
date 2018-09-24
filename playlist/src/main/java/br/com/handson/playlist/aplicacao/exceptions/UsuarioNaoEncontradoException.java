package br.com.handson.playlist.aplicacao.exceptions;

public class UsuarioNaoEncontradoException extends Exception {

    private final CodigoErro codigoErro;

    private final String[] detalhes;


    public UsuarioNaoEncontradoException(CodigoErro codigoErro, String... detalhes) {
        super("Erro " + codigoErro);
        this.codigoErro = codigoErro;
        this.detalhes = detalhes;
    }

}
