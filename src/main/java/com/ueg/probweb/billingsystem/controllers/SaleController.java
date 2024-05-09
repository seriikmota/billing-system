package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDateRangeDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import com.ueg.probweb.billingsystem.mappers.SaleMapper;
import com.ueg.probweb.billingsystem.services.ISaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/sale")
@Tag(name = "Venda")
public class SaleController {
    private final ISaleService service;
    private final SaleMapper mapper;

    public SaleController(ISaleService service, SaleMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(description = "Cadastrar uma venda", responses = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping
    @Transactional
    public ResponseEntity<Object> create(@RequestBody SaleCreateDTO dto){
        Object object = service.create(mapper.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @Operation(description = "Editar uma venda", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "428", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SaleUpdateDTO dto){
        Object object = service.update(id, mapper.toModel(dto));
        return ResponseEntity.ok(object);
    }

    @Operation(description = "Deletar uma venda", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "Listar todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping
    public ResponseEntity<Object> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(description = "Buscar uma venda pelo ID", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Sale.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(description = "Buscar as vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Sale.class)))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/salesPerDates")
    public ResponseEntity<Object> getSalesPerDates(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getSalesPerDates(dto.getInitialDate(), dto.getFinalDate()));
    }

    @Operation(description = "Pegar o valor total de todas vendas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/totalSalesPrice")
    public ResponseEntity<Object> getTotalSalesPrice(){
        return ResponseEntity.ok(service.getTotalSalesPrice());
    }

    @Operation(description = "Pegar o valor total das vendas entre datas", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Double.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/totalSalesPricePerDate")
    public ResponseEntity<Object> getTotalSalesPrice(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getTotalSalesPrice(dto.getInitialDate(), dto.getFinalDate()));
    }
}
