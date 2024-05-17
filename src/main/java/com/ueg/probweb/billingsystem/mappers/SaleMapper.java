package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.Sale;
import com.ueg.probweb.billingsystem.entities.dtos.SaleCreateDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleListDTO;
import com.ueg.probweb.billingsystem.entities.dtos.SaleUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SaleMapper extends GenericMapper<
        SaleDTO,
        SaleCreateDTO,
        SaleUpdateDTO,
        SaleListDTO,
        Sale,
        Long
        > {}
