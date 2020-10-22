package com.tiendd.bookservice.utils.validator;

import com.tiendd.bookservice.api.model.Author;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component("author")
public class AuthorValidator implements CommonValidator {
    @Override
    public boolean isValid(Object object) {
        return Optional.ofNullable(object)
                .filter(t -> !StringUtils.isEmpty(((Author) t).getName()))
                .isPresent();
    }
}
