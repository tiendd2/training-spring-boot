package com.tiendd.bookservice.utils.validator;

import com.tiendd.bookservice.api.model.Record;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component("record")
public class RecordValidator implements CommonValidator {
    @Override
    public boolean isValid(Object object) {
        return Optional.ofNullable(object)
                .filter(t -> !StringUtils.isEmpty(((Record) t).getDateCreated()))
                .filter(t -> !StringUtils.isEmpty(((Record) t).getPrice()))
                .isPresent();
    }
}
