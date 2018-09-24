package br.com.handson.playlist.aplicacao.repository.dto;

import br.com.handson.playlist.aplicacao.ws.v1.response.dto.MusicaV1DTO;

public class PlaylistMusicaDTO {

    private String playlistId;
    private String musicaId;
    private MusicaDTO musica;

    public PlaylistMusicaDTO(String playlistId, String musicaId, MusicaDTO musica) {
        this.playlistId = playlistId;
        this.musicaId = musicaId;
        this.musica = musica;
    }


    public String getPlaylistId() {
        return playlistId;
    }

    public String getMusicaId() {
        return musicaId;
    }

    public MusicaDTO getMusica() {
        return musica;
    }
}
