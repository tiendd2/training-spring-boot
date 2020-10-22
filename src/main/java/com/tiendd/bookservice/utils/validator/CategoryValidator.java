package com.tiendd.bookservice.utils.validator;

import com.tiendd.bookservice.api.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component("category")
public class CategoryValidator implements CommonValidator {
    @Override
    public boolean isValid(Object object) {
        return Optional.ofNullable(object)
                .filter(t -> !StringUtils.isEmpty(((Category) t).getName()))
                .isPresent();
    }
}
