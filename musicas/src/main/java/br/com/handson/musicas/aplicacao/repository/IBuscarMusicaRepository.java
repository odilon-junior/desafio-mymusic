package br.com.handson.musicas.aplicacao.repository;

import br.com.handson.musicas.aplicacao.repository.dto.MusicaDTO;

import java.util.List;

public interface IBuscarMusicaRepository {

    List<MusicaDTO> buscarPorNome(String nome);
}
