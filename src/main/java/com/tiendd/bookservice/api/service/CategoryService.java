package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryService extends CommonService{

    public CategoryService(@Qualifier("categoryRespository") JpaRepository repository,
                           @Qualifier("category") CommonValidator validator) {
        super(repository, validator);
    }

}
