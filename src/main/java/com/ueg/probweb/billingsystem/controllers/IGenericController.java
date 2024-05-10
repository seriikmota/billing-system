package com.ueg.probweb.billingsystem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGenericController<DTO, DTOCreate, DTOUpdate, DTOList, MODEL, TYPE_PK> {

    @Operation(description = "Cadastrar um registro", responses = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    ResponseEntity<DTO> create(@RequestBody DTOCreate dto);

    @Operation(description = "Editar um registro", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    ResponseEntity<DTO> update(@PathVariable TYPE_PK id, @RequestBody DTOUpdate dto);

    @Operation(description = "Deletar um registro", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<DTO> delete(@PathVariable TYPE_PK id);

    @Operation(description = "Listar todos os registro", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<List<DTOList>> listAll();

    @Operation(description = "Buscar um registro pelo ID", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<DTO> getById(@PathVariable TYPE_PK id);
}