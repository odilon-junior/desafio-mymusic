package br.com.handson.playlist.aplicacao.repository;

import br.com.handson.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBuscarUsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.nome = ?1")
    Usuario buscarPorUsuario(String user);
}
