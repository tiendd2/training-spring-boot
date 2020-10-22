package com.tiendd.bookservice.utils.validator;

import com.tiendd.bookservice.api.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component("book")
public class BookValidator implements CommonValidator {
    @Override
    public boolean isValid(Object object) {
        return Optional.ofNullable(object)
                .filter(t -> !StringUtils.isEmpty(((Book) t).getName()))
                .isPresent();
    }
}
