package com.ueg.probweb.billingsystem.services.impl;

import com.ueg.probweb.billingsystem.entities.GenericModel;
import com.ueg.probweb.billingsystem.exceptions.DataException;
import com.ueg.probweb.billingsystem.exceptions.ErrorEnum;
import com.ueg.probweb.billingsystem.exceptions.ParameterRequiredException;
import com.ueg.probweb.billingsystem.mappers.GenericUpdateMapper;
import com.ueg.probweb.billingsystem.services.IGenericService;
import com.ueg.probweb.billingsystem.services.validations.IValidations;
import com.ueg.probweb.billingsystem.services.validations.Impl.ValidationAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class GenericService<
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        REPOSITORY extends JpaRepository<MODEL, TYPE_PK>,
        VALIDATIONS extends IValidations<MODEL>
        >
        implements IGenericService<MODEL, TYPE_PK> {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GenericUpdateMapper<MODEL, TYPE_PK> mapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private REPOSITORY repository;

    @Autowired
    private List<VALIDATIONS> validations;

    public List<MODEL> listAll() {
        return repository.findAll();
    }

    public MODEL create(MODEL data) {
        prepareToCreate(data);
        validateForCreate(data);
        return repository.save(data);
    }

    public MODEL update(MODEL dataToUpdate){
        var dataDB = validateIdModelExistsAndGet(dataToUpdate.getId());
        validateForUpdate(dataToUpdate);
        updateDataDBFromUpdate(dataToUpdate, dataDB);
        return repository.save(dataDB);
    }

    public MODEL getById(TYPE_PK id){
        return this.validateIdModelExistsAndGet(id);
    }

    public MODEL deleteById(TYPE_PK id){
        MODEL modelToRemove = this.validateIdModelExistsAndGet(id);
        this.repository.delete(modelToRemove);
        return modelToRemove;
    }

    private MODEL validateIdModelExistsAndGet(TYPE_PK id){
        if (!Objects.nonNull(id)) throw new ParameterRequiredException("id");

        Optional<MODEL> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new DataException(ErrorEnum.NOT_FOUND);
        }
    }

    protected void updateDataDBFromUpdate(MODEL dataToUpdate, MODEL dataDB){
        mapper.updateModelFromModel(dataDB, dataToUpdate);
    }

    private void validateForCreate(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.CREATE));

    }
    private void validateForUpdate(MODEL data) {
        validations.forEach(v -> v.validate(data, ValidationAction.UPDATE));
    }

    protected abstract void prepareToCreate(MODEL data);
}
