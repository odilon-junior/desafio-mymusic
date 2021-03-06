package br.com.handson.playlist.aplicacao.ws.v1.response.dto;

public class UsuarioV1DTO {
    private String id;
    private String nome;
    private String playlistId;

    public UsuarioV1DTO(String id, String nome, String playlistId) {
        this.id = id;
        this.nome = nome;
        this.playlistId = playlistId;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPlaylistId() {
        return playlistId;
    }
}
