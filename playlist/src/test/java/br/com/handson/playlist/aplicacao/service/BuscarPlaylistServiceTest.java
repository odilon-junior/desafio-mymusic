package br.com.handson.playlist.aplicacao.service;

import br.com.handson.entity.Musica;
import br.com.handson.entity.PlayList;
import br.com.handson.entity.Usuario;
import br.com.handson.playlist.aplicacao.exceptions.UsuarioNaoEncontradoException;
import br.com.handson.playlist.aplicacao.repository.IBuscarUsuarioRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNotNull;

public class BuscarPlaylistServiceTest {

    private IBuscarUsuarioRepository buscarUsuarioRepository;

    @Before
    public void init(){
        buscarUsuarioRepository = createMock(IBuscarUsuarioRepository.class);
    }

    @Test(expected = UsuarioNaoEncontradoException.class)
    public void deveLancarUmaExceptionAOInformaUsuarioInexistente() throws UsuarioNaoEncontradoException {
        String usuario = "frod";
        expect(buscarUsuarioRepository.buscarPorUsuario(usuario)).andReturn(null);
        replay(buscarUsuarioRepository);

        IBuscarPlaylistService buscarPlaylistService = new BuscarPlayListServiceBean(buscarUsuarioRepository);
        buscarPlaylistService.buscarPorNomeUsuario(usuario);
    }

    @Test
    public void naoDeveLancarUmaExceptionAoInformarUmUsuarioExistente(){
        String nomeUsuario = "usuarioexistente";

        Usuario usuario = new Usuario();
        PlayList playList = new PlayList();
        playList.setMusicas(Arrays.asList(new Musica()));
        usuario.setPlayList(playList);
        expect(buscarUsuarioRepository.buscarPorUsuario(nomeUsuario)).andReturn(usuario);

        replay(buscarUsuarioRepository);

        Usuario usuarioEncontrado = buscarUsuarioRepository.buscarPorUsuario(nomeUsuario);

        assertNotNull(usuarioEncontrado);


    }
}
