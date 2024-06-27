package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.HighestDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDateRangeDTO;
import com.ueg.probweb.billingsystem.entities.dtos.TotalSalePerDateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ISaleController {
    @Operation(description = "Buscar as vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<List<Sale>> getSalesPerDates(@RequestBody SaleDateRangeDTO dto);

    @Operation(description = "Pegar o valor total de todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<Double> getTotalSalesPrice();

    @Operation(description = "Pegar o valor total das vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TotalSalePerDateDTO.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    ResponseEntity<List<TotalSalePerDateDTO>> getTotalSalePerDate(@RequestBody SaleDateRangeDTO dto);

    @Operation(description = "Pegar o cliente que mais comprou e o total", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = HighestDTO.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<HighestDTO> getHighestClient();

    @Operation(description = "Pegar o produto que mais lucrou e o total", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = HighestDTO.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<HighestDTO> getHighestProduct();

    @Operation(description = "Pegar o vendedor que mais vendeu e o total", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = HighestDTO.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    public ResponseEntity<HighestDTO> getHighestSeller();
}
