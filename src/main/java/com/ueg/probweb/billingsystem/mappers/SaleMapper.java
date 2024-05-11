package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleListDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring"
)
public interface SaleMapper extends GenericMapper<
        SaleDTO,
        SaleCreateDTO,
        SaleUpdateDTO,
        SaleListDTO,
        Sale,
        Long
        > {}
