package br.com.handson.playlist.aplicacao.repository.dto;

import java.util.List;

public class PlaylistDTO {

    private List<PlaylistMusicaDTO> playlistMusicas;
    private UsuarioDTO usuario;

    public PlaylistDTO(List<PlaylistMusicaDTO> playlistMusicas, UsuarioDTO usuario) {
        this.playlistMusicas = playlistMusicas;
        this.usuario = usuario;
    }

    public List<PlaylistMusicaDTO> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
}
