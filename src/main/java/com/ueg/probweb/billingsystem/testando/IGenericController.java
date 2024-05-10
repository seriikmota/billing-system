/*package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.GenericModel;
import com.ueg.probweb.billingsystem.mappers.GenericMapper;
import com.ueg.probweb.billingsystem.services.IGenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface IGenericController<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        TYPE_PK,
        MODEL extends GenericModel<TYPE_PK>,
        SERVICE extends IGenericService<MODEL, TYPE_PK>,
        MAPPER extends GenericMapper<DTO,DTOCreate, DTOUpdate, DTOList , MODEL, TYPE_PK>
        > {
    @Operation(description = "Cadastrar um objeto", responses = {
            //@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = MODEL.class))),
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<MODEL> create(DTOCreate dto);

    @Operation(description = "Editar um objeto", responses = {
            //@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = MODEL.class))),
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<MODEL> update(TYPE_PK id, DTOUpdate dto);

    @Operation(description = "Deletar um objeto", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<MODEL> delete(TYPE_PK id);

    @Operation(description = "Listar todos os objetos", responses = {
            //@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MODEL.class)))),
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<MODEL> listAll();

    @Operation(description = "Buscar um objeto pelo ID", responses = {
            //@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = MODEL.class))),
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<MODEL> getById(TYPE_PK id);
}
*/
