package com.ueg.probweb.billingsystem.services;

import com.ueg.probweb.billingsystem.entities.GenericModel;
import com.ueg.probweb.billingsystem.exceptions.DataException;
import com.ueg.probweb.billingsystem.exceptions.ErrorEnum;
import com.ueg.probweb.billingsystem.exceptions.ParameterRequiredException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class GenericService<
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        REPOSITORY extends JpaRepository<MODEL, TYPE_PK>
        >
        implements IGenericService<MODEL, TYPE_PK> {

    private final REPOSITORY repository;

    public GenericService(REPOSITORY repository) {
        this.repository = repository;
    }

    public List<MODEL> listAll() {
        return repository.findAll();
    }

    public MODEL create(MODEL data) {
        prepareToCreate(data);
        validateMandatoryFields(data);
        validateBusinessLogic(data);
        validateBusinessLogicForInsert(data);
        return repository.save(data);
    }

    public MODEL update(MODEL dataToUpdate){
        var dataDB = validateIdModelExistsAndGet(dataToUpdate.getId());
        validateMandatoryFields(dataToUpdate);
        validateBusinessLogic(dataToUpdate);
        validateBusinessLogicForUpdate(dataToUpdate);
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
        //mapper.updateModelFromModel(dataDB, dataToUpdate);
    }

    protected abstract void prepareToCreate(MODEL dado);
    protected abstract void validateMandatoryFields(MODEL dado);
    protected abstract void validateBusinessLogic(MODEL dado) ;
    protected abstract void validateBusinessLogicForInsert(MODEL dado);
    protected abstract void validateBusinessLogicForUpdate(MODEL dado);
}
