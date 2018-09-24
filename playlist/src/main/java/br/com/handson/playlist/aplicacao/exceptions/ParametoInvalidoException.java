package br.com.handson.playlist.aplicacao.exceptions;

public class ParametoInvalidoException extends IllegalArgumentException {

    private final CodigoErro codigoErro;

    private final String[] detalhes;

    public ParametoInvalidoException(CodigoErro codigoErro, String... detalhes) {
        super("Erro " + codigoErro);
        this.codigoErro = codigoErro;
        this.detalhes = detalhes;
    }

    public CodigoErro getCodigoErro() {
        return codigoErro;
    }

    public String[] getDetalhes() {
        return detalhes;
    }
}
