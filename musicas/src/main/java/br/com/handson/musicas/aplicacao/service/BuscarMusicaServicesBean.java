package br.com.handson.musicas.aplicacao.service;

import br.com.handson.musicas.aplicacao.commons.validador.string.QuantidadeMaximaCaracteres;
import br.com.handson.musicas.aplicacao.commons.validador.string.QuantidadeMininaCaracteres;
import br.com.handson.musicas.aplicacao.commons.validador.string.Validador;
import br.com.handson.musicas.aplicacao.commons.validador.string.ValidarDefault;
import br.com.handson.musicas.aplicacao.repository.IBuscarMusicaRepository;
import br.com.handson.musicas.aplicacao.repository.dto.MusicaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarMusicaServicesBean implements IBuscarMusicaServices {
    private Logger log =  LoggerFactory.getLogger(BuscarMusicaServicesBean.class);

    private IBuscarMusicaRepository buscarMusicaRepository;

    @Autowired
    public BuscarMusicaServicesBean(IBuscarMusicaRepository buscarMusicaRepository) {
        this.buscarMusicaRepository = buscarMusicaRepository;
    }

    @Override
    public List<MusicaDTO> buscarPorNome(String pNome) {

        log.info(String.format("Buscando musicas  %s", pNome));

        Validador validador = new QuantidadeMaximaCaracteres(100,
                new QuantidadeMininaCaracteres(3, new ValidarDefault()));

        validador.validar(pNome);

        return buscarMusicaRepository.buscarPorNome(pNome);

    }
}
