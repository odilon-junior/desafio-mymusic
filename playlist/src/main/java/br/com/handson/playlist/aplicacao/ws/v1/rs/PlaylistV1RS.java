package br.com.handson.playlist.aplicacao.ws.v1.rs;

import br.com.handson.entity.PlayList;
import br.com.handson.playlist.aplicacao.exceptions.UsuarioNaoEncontradoException;
import br.com.handson.playlist.aplicacao.repository.dto.PlaylistDTO;
import br.com.handson.playlist.aplicacao.repository.dto.PlaylistMusicaDTO;
import br.com.handson.playlist.aplicacao.service.IBuscarPlaylistService;
import br.com.handson.playlist.aplicacao.ws.v1.response.dto.*;
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

@Api(value = PlaylistV1RS.NOME_SERVICO, description = "Buscar playlist", basePath = "v1", tags = {"playlist"})
@RestController
@RequestMapping(value = PlaylistV1RS.NOME_SERVICO)
public class PlaylistV1RS {

    static final String NOME_SERVICO = "/v1/playlist";

    private IBuscarPlaylistService playlistService;

    @Autowired
    public PlaylistV1RS(IBuscarPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @ApiOperation(value = "Retorna as informações das playlist, dado o usuario", httpMethod = "GET",
            response = PlayList.class)
    @ApiResponses(value ={ @ApiResponse(code = 200, message = "OK"),
                            @ApiResponse(code = 204, message = "Usuario nao existente")})
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaylistV1DTO> getPlaylist(
            @ApiParam(value = "Nome da musica ou Artista com mais de 3 caracteres")
            @RequestParam(value = "usuario", required = true) String pNomeUsuario){

        PlaylistDTO playlist;
        try {
            playlist = playlistService.buscarPorNomeUsuario(pNomeUsuario);
        } catch (UsuarioNaoEncontradoException e) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(parserPlaylist(playlist), HttpStatus.OK);
    }

    private PlaylistV1DTO parserPlaylist(PlaylistDTO playlist) {
        List<PlaylistMusicaDTO> playlistMusicas = playlist.getPlaylistMusicas();

        List<PlaylistMusicaV1DTO> playListMusica = playlistMusicas.stream().map(x -> new PlaylistMusicaV1DTO(x.getPlaylistId(), x.getMusicaId(),
                new MusicaV1DTO(x.getMusica().getId(), x.getMusica().getNome(), x.getMusica().getArtistaId(),
                        new ArtistaV1DTO(x.getMusica().getArtista().getId(), x.getMusica().getNome()))))
                .collect(Collectors.toList());

        return new PlaylistV1DTO(new UsuarioV1DTO(playlist.getUsuario().getId(),
                playlist.getUsuario().getNome(), playlist.getUsuario().getPlaylistId()), playListMusica);
    }
}
