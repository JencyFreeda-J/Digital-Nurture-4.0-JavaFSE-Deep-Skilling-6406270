package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        LOGGER.info("Start authentication");

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.warn("Missing or invalid Authorization header");
            return ResponseEntity.status(401).body(Map.of("error", "Missing or invalid Authorization header"));
        }

        // Decode Base64 encoded credentials
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
        // credentials = username:password
        String[] values = credentials.split(":", 2);

        if (values.length != 2 || !jwtService.authenticate(values[0], values[1])) {
            LOGGER.warn("Invalid username or password");
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }

        String token = jwtService.generateToken(values[0]);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("Authentication successful, token generated");
        return ResponseEntity.ok(response);
    }
}