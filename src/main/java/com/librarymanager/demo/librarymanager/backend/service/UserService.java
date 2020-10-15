package com.librarymanager.demo.librarymanager.backend.service;

import com.librarymanager.demo.librarymanager.backend.model.CustomUserDetails;
import com.librarymanager.demo.librarymanager.backend.model.User;
import com.librarymanager.demo.librarymanager.backend.utils.UserValidator;
import com.librarymanager.demo.librarymanager.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    public User createUser(User user) {
        if (userValidator.isValid(user)) {
            return userRepository.save(user);
        }
        return null;
    }

    public User editUser(User user) {
        if (userValidator.isValid(user)) {
            return userRepository.save(user);
        }
        return null;
    }

    public boolean removeUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(user);
    }
}
