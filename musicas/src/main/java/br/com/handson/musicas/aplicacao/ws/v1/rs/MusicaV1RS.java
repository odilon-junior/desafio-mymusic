package br.com.handson.musicas.aplicacao.ws.v1.rs;


import br.com.handson.musicas.aplicacao.service.IBuscarMusicaServices;
import br.com.handson.musicas.aplicacao.ws.v1.response.dto.ArtistaV1DTO;
import br.com.handson.musicas.aplicacao.ws.v1.response.dto.MusicaV1DTO;
import br.com.handson.musicas.aplicacao.ws.v1.response.error.Erro;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = MusicaV1RS.NOME_SERVICO, description = "Buscar musicas", basePath = "v1", tags = {"musicas"})
@RestController
@RequestMapping(value = MusicaV1RS.NOME_SERVICO)
public class MusicaV1RS {

    static final String NOME_SERVICO = "/v1/musicas";

    private IBuscarMusicaServices buscarMusicaServices;

    @Autowired
    public MusicaV1RS(IBuscarMusicaServices buscarMusicaServices) {
        this.buscarMusicaServices = buscarMusicaServices;
    }

    @ApiOperation(value = "Retorna as informações das musicas, dado o nome", httpMethod = "GET", response = MusicaV1RS.class)
    @ApiResponses(value ={ @ApiResponse(code = 200, message = "OK"),
                            @ApiResponse(code = 400, message = "Dados de entrada invalido", response = Erro.class),
                            @ApiResponse(code = 204, message = "Dados nao encontrado")})
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MusicaV1DTO>> getMusicas(
            @ApiParam(value = "Nome da musica ou Artista com mais de 3 caracteres")
            @RequestParam("filtro") String filtro){

        List<MusicaV1DTO> musicas = buscarMusicaServices.buscarPorNome(filtro).stream()
                .map(x -> new MusicaV1DTO(x.getId(), x.getNome(), x.getArtistaId(),
                        new ArtistaV1DTO(x.getArtista().getId(), x.getArtista().getNome()))
                ).collect(Collectors.toList());

        HttpStatus status = musicas.isEmpty()? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity(musicas, status);
    }
}
