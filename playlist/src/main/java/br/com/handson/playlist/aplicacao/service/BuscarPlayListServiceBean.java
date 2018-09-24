package br.com.handson.playlist.aplicacao.service;

import br.com.handson.entity.Usuario;
import br.com.handson.playlist.aplicacao.exceptions.CodigoErro;
import br.com.handson.playlist.aplicacao.exceptions.UsuarioNaoEncontradoException;
import br.com.handson.playlist.aplicacao.repository.IBuscarUsuarioRepository;
import br.com.handson.playlist.aplicacao.repository.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarPlayListServiceBean implements IBuscarPlaylistService {

    private IBuscarUsuarioRepository buscarUsuarioRepository;

    @Autowired
    public BuscarPlayListServiceBean(IBuscarUsuarioRepository buscarUsuarioRepository) {
        this.buscarUsuarioRepository = buscarUsuarioRepository;
    }

    @Override
    public PlaylistDTO buscarPorNomeUsuario(String pNomeUsuario) throws UsuarioNaoEncontradoException {

        Usuario usuario = buscarUsuarioRepository.buscarPorUsuario(pNomeUsuario);

        if(usuario == null){
            throw new UsuarioNaoEncontradoException(CodigoErro.USUARIO_NAO_ENCONTRADO, "Usuario nao informado nao " +
                    "encontrado");
        }

        return this.parsePlaylis(usuario);
    }

    private PlaylistDTO parsePlaylis(Usuario usuario) {
        List<MusicaDTO> musicas = usuario.getPlayList().getMusicas().stream().map(x -> new MusicaDTO(x.getId(), x.getNome(),
                x.getArtista().getId(), new ArtistaDTO(x.getArtista().getId(),
                x.getArtista().getNome()))).collect(Collectors.toList());

        List<PlaylistMusicaDTO> playlistMusicas = musicas.stream().map(x -> new PlaylistMusicaDTO(x.getArtistaId(), x.getNome(),
                x)).collect(Collectors.toList());

        return  new PlaylistDTO(playlistMusicas, new UsuarioDTO(usuario.getId(), usuario.getNome(),
                usuario.getPlayList().getId()));
    }
}
