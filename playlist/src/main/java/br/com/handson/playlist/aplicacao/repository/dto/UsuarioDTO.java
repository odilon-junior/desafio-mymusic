package br.com.handson.playlist.aplicacao.repository.dto;

public class UsuarioDTO {
    private String id;
    private String nome;
    private String playlistId;

    public UsuarioDTO(String id, String nome, String playlistId) {
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
