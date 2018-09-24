package br.com.handson.playlist.aplicacao.repository.dto;

public class MusicaDTO {

    private String id;

    private String nome;

    private String artistaId;
    private ArtistaDTO artista;

    public MusicaDTO(String id, String nome, String artistaId, ArtistaDTO artista) {
        this.id = id;
        this.nome = nome;
        this.artistaId = artistaId;
        this.artista = artista;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getArtistaId() {
        return artistaId;
    }

    public ArtistaDTO getArtista() {
        return artista;
    }

}
