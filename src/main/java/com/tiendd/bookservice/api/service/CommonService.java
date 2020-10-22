package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CommonService {
    JpaRepository repository;

    CommonValidator validator;

    public CommonService(JpaRepository repository, CommonValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public Object editItem(Object object) {
        if (validator.isValid(object)) {
            return repository.save(object);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Object> findAll() {
        return repository.findAll();
    }

    public Object findById(Long id) {
        return repository.findById(id).get();
    }

    public Object addItem(Object object) {
        if(validator.isValid(object)){
            return repository.save(object);
        }
        return null;
    }
}
