package br.com.handson.musicas.aplicacao.repository.dto;

public class MusicaArtistaDTO {

    private String id;
    private String nome;
    private String artistaId;
    private String artistaNome;

    public MusicaArtistaDTO(String id, String nome, String artistaId, String artistaNome) {
        this.id = id;
        this.nome = nome;
        this.artistaId = artistaId;
        this.artistaNome = artistaNome;
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

    public String getArtistaNome() {
        return artistaNome;
    }
}
