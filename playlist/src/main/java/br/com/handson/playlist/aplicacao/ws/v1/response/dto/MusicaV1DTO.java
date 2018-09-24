package br.com.handson.playlist.aplicacao.ws.v1.response.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicaV1DTO {

    @ApiModelProperty(notes = "id da musica")
    private String id;

    @ApiModelProperty(notes = "nome da musica")
    private String nome;

    @ApiModelProperty(notes = "id do artista")
    private String artistaId;
    private ArtistaV1DTO artista;

    public MusicaV1DTO(String id, String nome, String artistaId, ArtistaV1DTO artista) {
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

    public ArtistaV1DTO getArtista() {
        return artista;
    }

}
