package com.tiendd.bookservice.api.service;

import com.tiendd.bookservice.utils.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class RecordService extends CommonService{

    public RecordService(@Qualifier("recordRespository") JpaRepository repository,
                         @Qualifier("record") CommonValidator validator) {
        super(repository, validator);
    }

}
