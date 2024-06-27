package com.ueg.probweb.billingsystem.controllers.Impl;

import com.ueg.probweb.billingsystem.controllers.ISaleController;
import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.*;
import com.ueg.probweb.billingsystem.mappers.SaleMapper;
import com.ueg.probweb.billingsystem.services.ISaleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Sale>> getSalesPerDates(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getSalesPerDates(dto.getInitialDate(), dto.getFinalDate()));
    }

    @GetMapping("/totalSalesPrice")
    public ResponseEntity<Double> getTotalSalesPrice(){
        return ResponseEntity.ok(service.getTotalSalesPrice());
    }

    @PostMapping("/totalSalesPricePerDate")
    public ResponseEntity<List<TotalSalePerDateDTO>> getTotalSalePerDate(@RequestBody SaleDateRangeDTO dto){
        return ResponseEntity.ok(service.getTotalSalesPrice(dto.getInitialDate(), dto.getFinalDate()));
    }

    @GetMapping("/getHighestClient")
    public ResponseEntity<HighestDTO> getHighestClient(){
        return ResponseEntity.ok(service.getHighestClient());
    }

    @GetMapping("/getHighestProduct")
    public ResponseEntity<HighestDTO> getHighestProduct(){
        return ResponseEntity.ok(service.getHighestProduct());
    }

    @GetMapping("/getHighestSeller")
    public ResponseEntity<HighestDTO> getHighestSeller(){
        return ResponseEntity.ok(service.getHighestSeller());
    }

}
