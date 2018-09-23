package br.com.handson.musicas.aplicacao.service;

import br.com.handson.musicas.aplicacao.exceptions.ParametoInvalidoException;
import br.com.handson.musicas.aplicacao.repository.BuscarMusicaRepositoryBean;
import br.com.handson.musicas.aplicacao.repository.IBuscarMusicaRepository;
import br.com.handson.musicas.aplicacao.repository.dto.ArtistaDTO;
import br.com.handson.musicas.aplicacao.repository.dto.MusicaDTO;
import br.com.handson.musicas.aplicacao.exceptions.CodigoErro;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BuscarMusicaServicesTest {

    private IBuscarMusicaRepository buscarMusicaRepository;

    @Before
    public void init(){
        buscarMusicaRepository = createMock(BuscarMusicaRepositoryBean.class);
    }

    @Test
    public void  deveLancarUmaExceptionComCodigoErroParametroNomeInvalido(){
        String nome = "Sy";
        IBuscarMusicaServices buscarMusicaServices = new BuscarMusicaServicesBean(buscarMusicaRepository);
        try {
            buscarMusicaServices.buscarPorNome(nome);
            fail();
        }catch (ParametoInvalidoException e){
            assertEquals(CodigoErro.PARAMETRO_NOME_INVALIDO, e.getCodigoErro());
        }
    }

    @Test
    public void deveRetornarUmaListaDeMusicas(){
        String nome = "System";
         expect(buscarMusicaRepository.buscarPorNome(nome)).andReturn(Arrays.asList(new MusicaDTO("","",
                 "", new ArtistaDTO("", ""))));

         replay(buscarMusicaRepository);

         IBuscarMusicaServices buscarMusicaServices = new BuscarMusicaServicesBean(buscarMusicaRepository);

        List<MusicaDTO> musicas = buscarMusicaServices.buscarPorNome(nome);

        assertNotNull(musicas);

    }
}
