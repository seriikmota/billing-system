package com.ueg.probweb.billingsystem.mappers;

import com.ueg.probweb.billingsystem.entities.GenericModel;
import org.mapstruct.MappingTarget;

public interface GenericUpdateMapper<
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > {
}
