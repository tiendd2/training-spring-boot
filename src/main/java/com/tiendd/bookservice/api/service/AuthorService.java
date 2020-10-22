package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthorService extends CommonService{

    public AuthorService(@Qualifier("authorRespository") JpaRepository repository,
                         @Qualifier("author") CommonValidator validator) {
        super(repository, validator);
    }

}
