package com.tiendd.bookservice.api.endpoint;

import com.tiendd.bookservice.api.model.Author;
import com.tiendd.bookservice.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorEndpoint {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAll")
    public List<Object> getListAuthor() {
        return authorService.findAll();
    }

    @GetMapping("/")
    public Author getAuthor(@PathVariable(name = "id") Long id){
        return (Author) authorService.findById(id);
    }

    @PutMapping("/")
    public Author editAuthor(@RequestBody Author author){
        return (Author) authorService.editItem(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable(name = "id") Long id){
        boolean result = authorService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return (Author) authorService.addItem(author);
    }
}
