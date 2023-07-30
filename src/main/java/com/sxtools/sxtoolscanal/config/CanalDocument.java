package com.sxtools.sxtoolscanal.config;

import com.sxtools.sxtoolscanal.dto.request.CanalRequest;
import com.sxtools.sxtoolscanal.dto.response.CanalResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Canal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CanalDocument {

    @Operation(summary = "Busca uma Lista de Canais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista Encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Canal.class))}),
            @ApiResponse(responseCode = "204", description = "Canais não encontrados",
                    content = @Content)})
    ResponseEntity<List<CanalResponse>> listaCanais ();

    @Operation(summary = "Busca uma Canais por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Canal Encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Canal.class))}),
            @ApiResponse(responseCode = "204", description = "Canal não encontrado",
                    content = @Content)})
    ResponseEntity<CanalResponse> getCanalId(Integer id);

    @Operation(summary = "Insere Um Canal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Canal Inserido com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Canal.class))}),
            @ApiResponse(responseCode = "400", description = "Erro ao Cadastrar Canal",
                    content = @Content)})
    ResponseEntity<DtoResponse> insereCanal(CanalRequest canalRequest);

    @Operation(summary = "Altera Um Canal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Canal Alterado com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Canal.class))}),
            @ApiResponse(responseCode = "204", description = "Erro ao alterar Canal",
                    content = @Content)})
    ResponseEntity<Optional<CanalResponse>> alteraCanal(CanalRequest canalRequest, Integer id);

    @Operation(summary = "Exclui Um Canal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Canal Excluido com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Canal.class))}),
            @ApiResponse(responseCode = "204", description = "Erro ao alterar Canal",
                    content = @Content)})
    void excluirCanal(Integer id);
}
