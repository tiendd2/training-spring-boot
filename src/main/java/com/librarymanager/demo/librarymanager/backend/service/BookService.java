package com.librarymanager.demo.librarymanager.backend.service;

import com.librarymanager.demo.librarymanager.backend.model.Book;
import com.librarymanager.demo.librarymanager.backend.utils.BookValidator;
import com.librarymanager.demo.librarymanager.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookValidator validator;

    public Book editItem(Book book) {
        if (validator.isValid(book)) {
            return bookRepository.save(book);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book addItem(Book book) {
        if(validator.isValid(book)){
            return bookRepository.save(book);
        }
        return null;
    }

    public List<Book> findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

}
