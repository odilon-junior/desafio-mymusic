package br.com.handson.playlist.aplicacao.ws.v1.response.dto;

import java.util.List;

public class PlaylistV1DTO {

    private List<PlaylistMusicaV1DTO> playlistMusicas;
    private UsuarioV1DTO usuario;

    public PlaylistV1DTO(UsuarioV1DTO usuario, List<PlaylistMusicaV1DTO> playlistMusicas) {
        this.playlistMusicas = playlistMusicas;
        this.usuario = usuario;
    }

    public List<PlaylistMusicaV1DTO> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public UsuarioV1DTO getUsuario() {
        return usuario;
    }
}
