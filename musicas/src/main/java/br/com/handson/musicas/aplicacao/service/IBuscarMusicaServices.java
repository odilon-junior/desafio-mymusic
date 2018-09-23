package br.com.handson.musicas.aplicacao.service;

import br.com.handson.musicas.aplicacao.repository.dto.MusicaDTO;

import java.util.List;

public interface IBuscarMusicaServices {

    List<MusicaDTO> buscarPorNome(String nome);
}
