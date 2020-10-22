package com.tiendd.bookservice.responsitory;

import com.tiendd.bookservice.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRespository extends JpaRepository<Author, Long> {
}
