package br.com.handson.musicas.aplicacao.repository.dto;

public class ArtistaDTO {

    private String id;
    private String nome;

    public ArtistaDTO(String id, String nome) {
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
