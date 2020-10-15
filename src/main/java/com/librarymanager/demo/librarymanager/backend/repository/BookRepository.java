package com.librarymanager.demo.librarymanager.backend.repository;

import com.librarymanager.demo.librarymanager.backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByName(String name);
}
