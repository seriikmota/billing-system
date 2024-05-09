package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.GenericModel;

public interface GenericMapper<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > {
}
