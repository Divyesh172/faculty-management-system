package com.example.faculty.controller;

import com.example.faculty.model.Faculty;
import com.example.faculty.service.FacultyService;
import com.example.faculty.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Faculty faculty) {
        Faculty savedUser = facultyService.registerFaculty(faculty);
        return ResponseEntity.ok(Map.of("message", "User registered successfully", "userId", savedUser.getId()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Faculty faculty = facultyService.authenticate(email, password);
        
        if (faculty == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }

        String token = jwtUtil.generateToken(email);
        
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("email", faculty.getEmail());
        response.put("fullName", faculty.getFullName());
        
        return ResponseEntity.ok(response);
    }
}
