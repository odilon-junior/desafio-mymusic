package br.com.handson.playlist.aplicacao.service;

import br.com.handson.playlist.aplicacao.exceptions.UsuarioNaoEncontradoException;
import br.com.handson.playlist.aplicacao.repository.dto.PlaylistDTO;

public interface IBuscarPlaylistService {

    PlaylistDTO buscarPorNomeUsuario(String pNomeUsuario) throws UsuarioNaoEncontradoException;
}
