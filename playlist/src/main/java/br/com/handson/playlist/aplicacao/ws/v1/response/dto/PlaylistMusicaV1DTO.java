package br.com.handson.playlist.aplicacao.ws.v1.response.dto;

public class PlaylistMusicaV1DTO {

    private String playlistId;
    private String musicaId;
    private MusicaV1DTO musica;

    public PlaylistMusicaV1DTO(String playlistId, String musicaId, MusicaV1DTO musica) {
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

    public MusicaV1DTO getMusica() {
        return musica;
    }
}
