package com.sxtools.sxtoolscanal.config;

import com.sxtools.sxtoolscanal.dto.request.ChannelRequest;
import com.sxtools.sxtoolscanal.dto.response.ChannelResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.Channel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ChannelDocument {

    @Operation(summary = "Busca uma Lista de Canais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista Encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Channel.class))}),
            @ApiResponse(responseCode = "204", description = "Canais não encontrados",
                    content = @Content)})
    ResponseEntity<List<ChannelResponse>> listaCanais();

    @Operation(summary = "Busca uma Canais por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel Encontrado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Channel.class))}),
            @ApiResponse(responseCode = "204", description = "Channel não encontrado",
                    content = @Content)})
    ResponseEntity<ChannelResponse> getCanalId(Integer id);

    @Operation(summary = "Insere Um Channel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Channel Inserido com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Channel.class))}),
            @ApiResponse(responseCode = "400", description = "Erro ao Cadastrar Channel",
                    content = @Content)})
    ResponseEntity<DtoResponse> insereCanal(ChannelRequest channelRequest);

    @Operation(summary = "Altera Um Channel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel Alterado com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Channel.class))}),
            @ApiResponse(responseCode = "204", description = "Erro ao alterar Channel",
                    content = @Content)})
    ResponseEntity<Optional<ChannelResponse>> alteraCanal(ChannelRequest channelRequest, Integer id);

    @Operation(summary = "Exclui Um Channel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Channel Excluido com Sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Channel.class))}),
            @ApiResponse(responseCode = "204", description = "Erro ao alterar Channel",
                    content = @Content)})
    void excluirCanal(Integer id);
}
