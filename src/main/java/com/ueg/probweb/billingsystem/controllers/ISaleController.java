package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDateRangeDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface ISaleController {

    @Operation(description = "Cadastrar uma venda", responses = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> create(SaleCreateDTO dto);

    @Operation(description = "Editar uma venda", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<Object> update(Long id, SaleUpdateDTO dto);

    @Operation(description = "Deletar uma venda", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Object> delete(Long id);

    @Operation(description = "Listar todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Object> listAll();

    @Operation(description = "Buscar uma venda pelo ID", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Sale> getById(Long id);

    @Operation(description = "Buscar as vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Object> getSalesPerDates(SaleDateRangeDTO dto);

    @Operation(description = "Pegar o valor total de todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Object> getTotalSalesPrice();

    @Operation(description = "Pegar o valor total das vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<Object> getTotalSalesPrice(SaleDateRangeDTO dto);
}
