package com.librarymanager.demo.librarymanager.backend.api;

import com.librarymanager.demo.librarymanager.backend.model.User;
import com.librarymanager.demo.librarymanager.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestAPIUserController {
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/user/getAllUser")
    public List<User> getListUser() {
        return userService.findAll();
    }

    @GetMapping("/user/getUser")
    public User getUser(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

    @PutMapping("/user/editUser")
    public User editUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.editUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteTodo(@PathVariable(name = "id") Long id){
        boolean result = userService.removeUser(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user/createUser")
    public ResponseEntity addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User response = userService.createUser(user);
        return ResponseEntity.ok().body(response);
    }



}
