package br.com.handson.musicas.aplicacao.ws.v1.response.dto;


public class ArtistaV1DTO{

    private String id;
    private String nome;

    public ArtistaV1DTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
