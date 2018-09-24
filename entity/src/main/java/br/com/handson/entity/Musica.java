package br.com.handson.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "musicas")
public class Musica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArtistaId", referencedColumnName = "id")
    private Artista artista;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
