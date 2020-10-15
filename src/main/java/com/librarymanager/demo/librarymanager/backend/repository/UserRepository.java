package com.librarymanager.demo.librarymanager.backend.repository;

import com.librarymanager.demo.librarymanager.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
