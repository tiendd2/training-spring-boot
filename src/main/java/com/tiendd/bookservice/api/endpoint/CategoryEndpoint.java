package com.tiendd.bookservice.api.endpoint;

import com.tiendd.bookservice.api.model.Category;
import com.tiendd.bookservice.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryEndpoint {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Object> getListCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/")
    public Category getCategory(@PathVariable(name = "id") Long id){
        return (Category) categoryService.findById(id);
    }

    @PutMapping("/")
    public Category edit(@RequestBody Category category){
        return (Category) categoryService.editItem(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id") Long id){
        boolean result = categoryService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return (Category) categoryService.addItem(category);
    }

}
