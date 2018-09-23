package br.com.handson.musicas.aplicacao.ws.v1.response.error;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "informações de erro")
public class Erro {

    private String codigo;
    private String mensagem;

    public Erro() {}

    public Erro(String mensagem) {
        this.mensagem = mensagem;
        codigo = null;
    }

    public Erro(String mensagem, String codigo) {
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
