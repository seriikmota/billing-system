package com.ueg.probweb.billingsystem.controllers.Impl;

import com.ueg.probweb.billingsystem.controllers.IGenericController;
import com.ueg.probweb.billingsystem.entities.GenericModel;
import com.ueg.probweb.billingsystem.mappers.GenericMapper;
import com.ueg.probweb.billingsystem.services.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        SERVICE extends IGenericService<MODEL, TYPE_PK>,
        MAPPER extends GenericMapper<DTO,DTOCreate, DTOUpdate, DTOList , MODEL, TYPE_PK>
        > implements IGenericController<DTO, DTOCreate, DTOUpdate, DTOList, MODEL, TYPE_PK>
{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    @PostMapping
    @Transactional
    public ResponseEntity<DTO> create(@RequestBody DTOCreate dto){
        MODEL inputModel = mapper.fromModelCreatedToModel(dto);
        DTO resultDTO = mapper.toDTO(service.create(inputModel));
        return ResponseEntity.ok(resultDTO);
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<DTO> update(@PathVariable TYPE_PK id, @RequestBody DTOUpdate dto){
        MODEL inputModel = mapper.fromModelUpdatedToModel(dto);
        inputModel.setId(id);
        MODEL modelSaved = service.update(inputModel);
        return ResponseEntity.ok(mapper.toDTO(modelSaved));
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<DTO> delete(@PathVariable TYPE_PK id){
        DTO dtoResult = mapper.toDTO(service.deleteById(id));
        return ResponseEntity.ok(dtoResult);
    }

    @GetMapping
    public ResponseEntity<List<DTOList>> listAll(){
        List<DTOList> modelList = mapper.fromModelToDTOList(service.listAll());
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTO> getById(@PathVariable TYPE_PK id){
        DTO dtoResult = mapper.toDTO(service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }

}