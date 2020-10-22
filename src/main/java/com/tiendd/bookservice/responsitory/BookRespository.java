package com.tiendd.bookservice.responsitory;

import com.tiendd.bookservice.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book, Long> {
}
