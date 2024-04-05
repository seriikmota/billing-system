package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.CreateSaleDTO;
import com.ueg.probweb.billingsystem.entities.dtos.UpdateSaleDTO;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper {
    public Sale toModel(CreateSaleDTO dto){
        Sale s = new Sale();
        s.setSeller(dto.getSeller());
        s.setClient(dto.getClient());
        s.setProduct(dto.getProduct());
        s.setProductPrice(dto.getProductPrice());
        s.setSalePrice(dto.getSalePrice());
        s.setSituation(dto.getSituation());
        return s;
    }
    public Sale toModel(UpdateSaleDTO dto){
        Sale s = new Sale();
        s.setProduct(dto.getProduct());
        s.setProductPrice(dto.getProductPrice());
        s.setSalePrice(dto.getSalePrice());
        s.setSituation(dto.getSituation());
        return s;
    }
}
