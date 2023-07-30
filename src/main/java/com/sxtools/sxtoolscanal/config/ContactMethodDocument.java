package com.sxtools.sxtoolscanal.config;


import com.sxtools.sxtoolscanal.dto.request.ContactMethodRequest;
import com.sxtools.sxtoolscanal.dto.response.ContactMethodResponse;
import com.sxtools.sxtoolscanal.dto.response.DtoResponse;
import com.sxtools.sxtoolscanal.entity.ContactMethod;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ContactMethodDocument {

    @Operation(summary = "List ContactMethod by filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))})})
    ResponseEntity<List<ContactMethodResponse>> listContactMethods ();

    @Operation(summary = "Get an ContactMethod by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))})})

    ResponseEntity<ContactMethodResponse> getContactMethodId(Integer id);

    @Operation(summary = "Create a new ContactMethod")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))})})
    ResponseEntity<DtoResponse> insereContactMethod(ContactMethodRequest contactMethodRequest);

    @Operation(summary = "Replace all ContactMethod data using request body information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "401", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "403", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "406", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ContactMethod.class))}),

            @ApiResponse(responseCode = "400", content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ContactMethod.class))})})

    ResponseEntity<Optional<ContactMethodResponse>> alteraContactMethod(ContactMethodRequest contactMethodRequest, Integer id);

}
