package com.librarymanager.demo.librarymanager.backend.utils;

import com.librarymanager.demo.librarymanager.backend.model.Book;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class BookValidator {

    public boolean isValid(Book book) {
        return Optional.ofNullable(book)
                .filter(t -> !StringUtils.isEmpty(t.getName()))
                .filter(t -> !StringUtils.isEmpty(t.getDetail()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
