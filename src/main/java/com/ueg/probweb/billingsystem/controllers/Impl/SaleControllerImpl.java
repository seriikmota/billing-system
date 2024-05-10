package com.ueg.probweb.billingsystem.controllers.Impl;

import com.ueg.probweb.billingsystem.controllers.ISaleController;
import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.*;
import com.ueg.probweb.billingsystem.mappers.SaleMapper;
import com.ueg.probweb.billingsystem.services.ISaleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/sale")
@Tag(name = "Venda")
@CrossOrigin()
public class SaleControllerImpl extends GenericController<
        SaleDTO,
        SaleCreateDTO,
        SaleUpdateDTO,
        SaleListDTO,
        Sale,
        Long,
        ISaleService,
        SaleMapper> implements ISaleController {

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
