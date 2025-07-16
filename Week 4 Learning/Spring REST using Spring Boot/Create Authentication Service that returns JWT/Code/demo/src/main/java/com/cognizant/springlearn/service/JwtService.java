package com.cognizant.springlearn.service;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.util.JwtUtil;

@Service
public class JwtService {

    // Hardcoded user credentials for demonstration
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pwd";

    public boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public String generateToken(String username) {
        return JwtUtil.generateToken(username);
    }
}