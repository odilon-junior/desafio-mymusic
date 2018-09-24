package br.com.handson.playlist.aplicacao.repository;

import br.com.handson.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class BuscarUsuarioRepositoryBean {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
    public boolean possuiUsuario(String nome) {

        StringBuilder jpql = new StringBuilder("SELECT u.id FROM ")
        .append(Usuario.class.getCanonicalName())
        .append(" u ").append(" WHERE u.nome = :NOME");

        Query query = entityManager.createQuery(jpql.toString());

        query.setParameter("NOME", nome);

        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            e.printStackTrace();
            return false;
        }
    }
}
