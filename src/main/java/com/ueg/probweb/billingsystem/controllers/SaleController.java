package com.ueg.probweb.billingsystem.controllers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDateRangeDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import com.ueg.probweb.billingsystem.mappers.SaleMapper1;
import com.ueg.probweb.billingsystem.services.ISaleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/sale")
@Tag(name = "Venda")
public class SaleController implements ISaleController {
    private final ISaleService service;
    private final SaleMapper1 mapper;

    public SaleController(ISaleService service, SaleMapper1 mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> create(@RequestBody SaleCreateDTO dto){
        Object object = service.create(mapper.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SaleUpdateDTO dto){
        Object object = service.update(id, mapper.toModel(dto));
        return ResponseEntity.ok(object);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Object> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/salesPerDates")
    public ResponseEntity<Object> getSalesPerDates(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getSalesPerDates(dto.getInitialDate(), dto.getFinalDate()));
    }

    @GetMapping("/totalSalesPrice")
    public ResponseEntity<Object> getTotalSalesPrice(){
        return ResponseEntity.ok(service.getTotalSalesPrice());
    }

    @GetMapping("/totalSalesPricePerDate")
    public ResponseEntity<Object> getTotalSalesPrice(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getTotalSalesPrice(dto.getInitialDate(), dto.getFinalDate()));
    }
}
