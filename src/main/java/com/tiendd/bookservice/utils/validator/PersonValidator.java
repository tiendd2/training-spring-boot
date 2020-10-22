package com.tiendd.bookservice.utils.validator;

import com.tiendd.bookservice.api.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component("person")
public class PersonValidator implements CommonValidator {
    @Override
    public boolean isValid(Object object) {
        return Optional.ofNullable(object)
                .filter(t -> !StringUtils.isEmpty(((Person) t).getFullName()))
                .filter(t -> !StringUtils.isEmpty(((Person) t).getPhoneNumber()))
                .isPresent();
    }
}
