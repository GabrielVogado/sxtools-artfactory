package com.sxtools.sxtoolscanal.config;


import com.sxtools.sxtoolscanal.dto.request.SeverityRequest;
import com.sxtools.sxtoolscanal.dto.response.SeverityResponse;
import com.sxtools.sxtoolscanal.entity.Severity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SeverityDocument {

    @Operation(summary = "List severity by filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))})})
    ResponseEntity<List<SeverityResponse>> listSeverities ();

    @Operation(summary = "Get an severity by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))})})

    ResponseEntity<SeverityResponse> getSeverityId(Integer id);

    @Operation(summary = "Create a new severity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))})})

    ResponseEntity<SeverityResponse> insereSeverity(SeverityRequest severityRequest);

    @Operation(summary = "Replace all severity data using request body information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Severity.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Severity.class))})})

    ResponseEntity<Optional<SeverityResponse>> alteraSeverity(SeverityRequest severityRequest, Integer id);

}
