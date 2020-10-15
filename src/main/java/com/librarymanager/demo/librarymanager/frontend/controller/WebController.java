package com.librarymanager.demo.librarymanager.frontend.controller;

import com.librarymanager.demo.librarymanager.backend.api.RestAPIBookController;
import com.librarymanager.demo.librarymanager.backend.model.Book;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class WebController {
    List<Book> bookList = new CopyOnWriteArrayList<>();

    @Autowired
    private RestAPIBookController restAPI;

    @PostConstruct
    public void init(){
        bookList = restAPI.getListBook();
    }

    @PostMapping("/addBook")
    public String addTodo(@ModelAttribute Book book) {
        return Optional.ofNullable(restAPI.addBook(book))
                .map(t -> "success")
                .orElse("failed");

    }

    @GetMapping("/addBook")
    public String addTodo(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @GetMapping(value = {"/", "/home"})
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        bookList = restAPI.getListBook();
        // Trả về đối tượng todoList.
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
        model.addAttribute("bookList", limit != null ? bookList.subList(0, limit) : bookList);
        // Trả về template "listTodo.html"
        return "index";
    }

}