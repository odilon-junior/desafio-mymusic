package br.com.handson.musicas.aplicacao.repository;

import br.com.handson.musicas.aplicacao.repository.dto.ArtistaDTO;
import br.com.handson.musicas.aplicacao.repository.dto.MusicaArtistaDTO;
import br.com.handson.musicas.aplicacao.repository.dto.MusicaDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuscarMusicaRepositoryBean implements IBuscarMusicaRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<MusicaDTO> buscarPorNome(String nome) {

        StringBuilder jpql = new StringBuilder("SELECT new ");
        jpql.append(MusicaArtistaDTO.class.getCanonicalName());
        jpql.append(" (m.id, m.nome, a.id, a.nome)");
        jpql.append(" FROM Musica m ");
        jpql.append(" LEFT JOIN m.artista a");
        jpql.append(" WHERE m.nome LIKE :NOME");
        jpql.append(" OR a.nome LIKE :NOME");
        jpql.append(" ORDER BY a.nome, m.nome");

        TypedQuery<MusicaArtistaDTO> query = entityManager.createQuery(jpql.toString(), MusicaArtistaDTO.class);
        query.setParameter("NOME", "%" + nome + "%");

        List<MusicaArtistaDTO> musicas = query.getResultList();

        return musicas.stream().map(x -> new MusicaDTO(x.getId(), x.getNome(), x.getArtistaId(), new ArtistaDTO(x.getArtistaId(),
                x.getArtistaNome()))).collect(Collectors.toList());

    }
}
