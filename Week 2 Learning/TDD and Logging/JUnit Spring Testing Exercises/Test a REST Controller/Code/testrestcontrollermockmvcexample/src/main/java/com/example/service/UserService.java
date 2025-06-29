package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(Long id) {
        return new User(id, "John Doe");
    }
}