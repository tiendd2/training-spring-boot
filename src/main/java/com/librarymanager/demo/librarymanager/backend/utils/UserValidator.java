package com.librarymanager.demo.librarymanager.backend.utils;

import com.librarymanager.demo.librarymanager.backend.model.User;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class UserValidator {

    public boolean isValid(User user) {
        return Optional.ofNullable(user)
                .filter(t -> !StringUtils.isEmpty(t.getFullname()))
                .filter(t -> !StringUtils.isEmpty(t.getUsername()))
                .filter(t -> !StringUtils.isEmpty(t.getPassword()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
