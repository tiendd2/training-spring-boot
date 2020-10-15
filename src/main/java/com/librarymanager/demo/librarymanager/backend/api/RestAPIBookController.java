package com.librarymanager.demo.librarymanager.backend.api;

import com.librarymanager.demo.librarymanager.backend.jwt.JwtTokenProvider;
import com.librarymanager.demo.librarymanager.backend.model.Book;
import com.librarymanager.demo.librarymanager.backend.model.CustomUserDetails;
import com.librarymanager.demo.librarymanager.backend.model.LoginRequest;
import com.librarymanager.demo.librarymanager.backend.model.LoginResponse;
import com.librarymanager.demo.librarymanager.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestAPIBookController {
    @Autowired
    private BookService bookService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực thông tin người dùng Request lên
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        System.out.println(jwt);
        return new LoginResponse(jwt);
    }

    @GetMapping("/book/getAllBook")
    public List<Book> getListBook() {
        return bookService.findAll();
    }

    @GetMapping("/book/getBookByName")
    public List<Book> getBookByName(@RequestParam(name = "name", required = false) String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/book/getBook")
    public Book getBook(@PathVariable(name = "id") Long id){
        return bookService.findById(id);
    }

    @PutMapping("/book/editBook")
    public Book editBook(@RequestBody Book book){
        return bookService.editItem(book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable(name = "id") Long id){
        boolean result = bookService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/book/addBook")
    public ResponseEntity addBook(@RequestBody Book book) {
        Book response = bookService.addItem(book);
        return ResponseEntity.ok().body(response);
    }

}
