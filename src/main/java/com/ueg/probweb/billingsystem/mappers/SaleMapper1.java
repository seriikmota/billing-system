package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper1 {
    public Sale toModel(SaleCreateDTO dto){
        Sale s = new Sale();
        s.setSeller(dto.getSeller());
        s.setClient(dto.getClient());
        s.setProduct(dto.getProduct());
        s.setProductPrice(dto.getProductPrice());
        s.setSalePrice(dto.getSalePrice());
        s.setSituation(dto.getSituation());
        return s;
    }
    public Sale toModel(SaleUpdateDTO dto){
        Sale s = new Sale();
        s.setProduct(dto.getProduct());
        s.setProductPrice(dto.getProductPrice());
        s.setSalePrice(dto.getSalePrice());
        s.setSituation(dto.getSituation());
        return s;
    }
}
