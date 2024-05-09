package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.GenericModel;

import java.util.List;

public interface IGenericService<MODEL extends GenericModel<TYPE_PK>, TYPE_PK> {
    List<MODEL> listAll();
    MODEL create(MODEL data);
    MODEL update(MODEL data);
    MODEL getById(TYPE_PK id);
    MODEL deleteById(TYPE_PK id);
}
