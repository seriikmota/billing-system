package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDateRangeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ISaleController {
    @Operation(description = "Buscar as vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<Object> getSalesPerDates(@RequestBody SaleDateRangeDTO dto);

    @Operation(description = "Pegar o valor total de todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<Object> getTotalSalesPrice();

    @Operation(description = "Pegar o valor total das vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<Object> getTotalSalesPrice(@RequestBody SaleDateRangeDTO dto);
}
