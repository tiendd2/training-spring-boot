package com.tiendd.bookservice.api.endpoint;

import com.tiendd.bookservice.api.model.Book;
import com.tiendd.bookservice.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookEndpoint {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public List<Object> getListBook() {
        return bookService.findAll();
    }

    @GetMapping("/")
    public Book getBook(@PathVariable(name = "id") Long id){
        return (Book) bookService.findById(id);
    }

    @PutMapping("/")
    public Book editBook(@RequestBody Book book){
        return (Book) bookService.editItem(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id") Long id){
        boolean result = bookService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return (Book) bookService.addItem(book);
    }
}
